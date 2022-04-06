package com.example.encryption.model;

import com.example.encryption.utils.Encrypted;
import com.example.encryption.utils.EncryptionListener;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.context.event.EventListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Encrypted
  private String name;
  private int age;
  @Encrypted
  private String contactNumber;
  @Encrypted
  private String email;
}
