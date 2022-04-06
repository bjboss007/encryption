package com.example.encryption.utils;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper modelMapper(){
    return new ModelMapper();
  }

}
