package com.example.encryption.utils;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityEncryptionRegistry {

  @Autowired
  private EntityManager entityManagerFactory;

  private static final Logger logger = LoggerFactory.getLogger(EntityEncryptionRegistry.class);
  @Autowired
  private EncryptionListener encryptionListener;

  @PostConstruct
  public void registerListeners() {
    Session session = entityManagerFactory.unwrap(Session.class);
    SessionFactory sessionFactory = session.getSessionFactory();
    EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);

    registry.getEventListenerGroup(EventType.PRE_LOAD)
        .appendListener(encryptionListener);

    registry.getEventListenerGroup(EventType.PRE_INSERT)
        .appendListener(encryptionListener);

    registry.getEventListenerGroup(EventType.PRE_UPDATE)
        .appendListener(encryptionListener);

    logger.info("Listeners registered successfully");
  }

}
