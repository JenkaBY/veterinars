package io.by.lt.pl.presentation;

import io.by.lt.pl.service.PersonService;
import io.by.lt.pl.service.dto.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }


    @PostMapping
    public Person create(@RequestBody Person request) {
        return personService.create(request);
    }
}
