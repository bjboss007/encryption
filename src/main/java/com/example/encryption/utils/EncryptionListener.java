package com.example.encryption.utils;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptionListener implements PreInsertEventListener, PreUpdateEventListener,
    PreLoadEventListener {

  @Autowired
  FieldDecrypter fieldDecrypter;
  @Autowired
  FieldEncrypter fieldEncrypter;

  @Override
  public boolean onPreInsert(PreInsertEvent event) {

    System.out.println("I got called before");
    Object[] state = event.getState();
    String[] propertyNames = event.getPersister().getPropertyNames();
    Object entity = event.getEntity();
    fieldEncrypter.encrypt(state, propertyNames, entity);
    return false;
  }

  @Override
  public void onPreLoad(PreLoadEvent event) {
    System.out.println("I got called before loading");
    Object[] state = event.getState();
    String[] propertyNames = event.getPersister().getPropertyNames();
    Object entity = event.getEntity();
    fieldDecrypter.decrypt(state, propertyNames, entity);
  }

  @Override
  public boolean onPreUpdate(PreUpdateEvent event) {
    System.out.println("I got got called when updating the object");
    Object[] state = event.getState();
    String[] propertyNames = event.getPersister().getPropertyNames();
    Object entity = event.getEntity();
    fieldEncrypter.encrypt(state, propertyNames, entity);
    return false;
  }
}
