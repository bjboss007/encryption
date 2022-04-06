package com.example.encryption.service;

import com.example.encryption.model.Person;
import com.example.encryption.model.dto.PersonDTO;
import com.example.encryption.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

  private final PersonRepository repository;
  private final ModelMapper modelMapper;
  @Override
  public Person getPersonById(Long id) {
    return repository.findById(id).orElseThrow();
  }

  @Override
  public Person createPerson(PersonDTO personDTO) {
    Person person = modelMapper.map(personDTO, Person.class);
    return repository.save(person);
  }
}
