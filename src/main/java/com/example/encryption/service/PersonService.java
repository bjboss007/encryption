package com.example.encryption.service;

import com.example.encryption.model.Person;
import com.example.encryption.model.dto.PersonDTO;
import org.springframework.http.ResponseEntity;

public interface PersonService {
  Person getPersonById(Long id);

  Person createPerson(PersonDTO personDTO);
}
