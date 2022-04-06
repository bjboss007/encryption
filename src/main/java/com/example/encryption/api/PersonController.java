package com.example.encryption.api;


import com.example.encryption.model.Person;
import com.example.encryption.model.dto.PersonDTO;
import com.example.encryption.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping("{id}")
  public ResponseEntity<?> getPerson(@PathVariable("id") Long id){
      return ResponseEntity.ok(personService.getPersonById(id));
  }

  @PostMapping
  public ResponseEntity<?> createPerson(@RequestBody PersonDTO personDTO){
    Person person = personService.createPerson(personDTO);
    return ResponseEntity.ok(person);

  }
}
