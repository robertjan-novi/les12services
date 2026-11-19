package nl.novi.demo.les12services.mapper;

import nl.novi.demo.les12services.dto.PersonRequestDto;
import nl.novi.demo.les12services.dto.PersonResponseDto;
import nl.novi.demo.les12services.model.Person;

public class PersonMapper {

    // DTO -> Entity
    public static Person toEntity(PersonRequestDto personRequestDto) {
         Person p = new Person();

         p.setName(personRequestDto.name());
         p.setDob(personRequestDto.dob());

         return p;
     }

     // Entity -> DTO
     public static PersonResponseDto toResponseDto(Person person) {
        return new PersonResponseDto(
               person.getId(), person.getName(), person.getDob()
        );
     }
}
