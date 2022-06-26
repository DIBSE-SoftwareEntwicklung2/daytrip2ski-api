package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/person")
@Validated
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> findPersonById(@PathVariable("id") Long id) {
        return personService.findPersonById(id);
    }

    @GetMapping(path = "score/{personId}")
    public Optional<Score> findScorePersonById(@PathVariable("personId") Long personId) {
        return personService.findPersonScoreById(personId);
    }

    @PostMapping(path = "register")
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @PostMapping(path = "save")
    public void savePerson(@RequestBody Person person) { personService.savePerson(person);}

    @DeleteMapping(path ="{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }


}
