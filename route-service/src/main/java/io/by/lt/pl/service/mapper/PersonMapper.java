package io.by.lt.pl.service.mapper;

import io.by.lt.pl.persistance.entity.PersonEntity;
import io.by.lt.pl.service.dto.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toModel(PersonEntity source) {
        if (source == null) return null;
        return new Person(source.id(), source.name(), source.address(), source.city());
    }

    public PersonEntity toEntity(Person source) {
        if (source == null) return null;
        return new PersonEntity(source.id(), source.name(), source.address(), source.city());
    }
}
