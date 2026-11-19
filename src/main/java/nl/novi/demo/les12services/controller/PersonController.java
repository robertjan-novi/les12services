package nl.novi.demo.les12services.controller;

import jakarta.validation.Valid;
import nl.novi.demo.les12services.dto.PersonRequestDto;
import nl.novi.demo.les12services.dto.PersonResponseDto;
import nl.novi.demo.les12services.model.Person;
import nl.novi.demo.les12services.repository.PersonRepository;
import nl.novi.demo.les12services.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

//    @GetMapping
//    public ResponseEntity<List<Person>> getPersons() {
//        List<Person> persons = this.repos.findAll();
//        return ResponseEntity.ok(persons);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable int id) {
        PersonResponseDto personResponseDto = this.service.getPersonById(id);
        return ResponseEntity.ok(personResponseDto);  // happy flow
    }

    @PostMapping
    public ResponseEntity<PersonResponseDto> createPerson(@Valid @RequestBody PersonRequestDto personRequestDto) {
        PersonResponseDto personResponseDto = this.service.createPerson(personRequestDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/" + personResponseDto.id()).toUriString());

        return ResponseEntity.created(uri).body(personResponseDto);
    }

}
