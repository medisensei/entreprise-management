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
                .id(personDTO.getId())
                .name(personDTO.getName())
                .rib(personDTO.getRib())
                .cin(personDTO.getCin())
                .email(personDTO.getEmail())
                .phone(personDTO.getPhone())
                .address(personDTO.getAddress())
                .build();
    }

    @Override
    public PersonDTO toDto(Person person) {
        if (person == null) return null;
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .rib(person.getRib())
                .cin(person.getCin())
                .email(person.getEmail())
                .phone(person.getPhone())
                .address(person.getAddress())
                .build();
    }
}
