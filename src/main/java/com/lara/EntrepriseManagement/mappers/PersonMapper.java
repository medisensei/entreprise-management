package com.lara.EntrepriseManagement.mappers;

import com.lara.EntrepriseManagement.dto.PersonDTO;
import com.lara.EntrepriseManagement.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonDTO> {

    @Override
    public Person toEntity(PersonDTO personDTO) {
        if (personDTO == null) return null;
        return Person.builder()
                .id(personDTO.id())
                .name(personDTO.name())
                .rib(personDTO.rib())
                .cin(personDTO.cin())
                .email(personDTO.email())
                .phone(personDTO.phone())
                .address(personDTO.address())
                .build();
    }

    @Override
    public PersonDTO toDto(Person person) {
        if (person == null) return null;
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getRib(),
                person.getCin(),
                person.getEmail(),
                person.getPhone(),
                person.getAddress()
        );
    }
}
