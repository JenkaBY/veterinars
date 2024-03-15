package io.by.lt.pl.service;

import io.by.lt.pl.persistance.repository.PersonRepository;
import io.by.lt.pl.service.dto.Person;
import io.by.lt.pl.service.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<Person> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toModel)
                .toList();
    }

    public Person create(Person person) {
        return personMapper.toModel(personRepository.createPerson(personMapper.toEntity(person)));
    }
}
