package nl.novi.demo.les12services.service;

import nl.novi.demo.les12services.dto.PersonRequestDto;
import nl.novi.demo.les12services.dto.PersonResponseDto;
import nl.novi.demo.les12services.exception.ResourceNotFoundException;
import nl.novi.demo.les12services.mapper.PersonMapper;
import nl.novi.demo.les12services.model.Person;
import nl.novi.demo.les12services.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repos;

    public PersonService(PersonRepository repos) {
        this.repos = repos;
    }

    // CRUD operaties

    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        Person person = repos.save(PersonMapper.toEntity(personRequestDto));

        return PersonMapper.toResponseDto(person);
    }

    public PersonResponseDto getPersonById(int id) {
        Person person = repos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        return PersonMapper.toResponseDto(person);
    }
}
