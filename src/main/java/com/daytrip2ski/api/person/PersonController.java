package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller layer of person
 * <a href="http://daytrip2ski-api.herokuapp.com/swagger-ui.html#/person-controller">API docukentation</a>
 */
@RestController
@RequestMapping(path = "api/v1/person")
@Validated
public class PersonController {
    private final PersonService personService;

    /**
     * Constructor
     * @param personService service of class person
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Get all persons
     * @return list of persons
     */
    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    /**
     * Get person by id
     * @param id id
     * @return person
     */
    @GetMapping(path = "{id}")
    public Optional<Person> findPersonById(@PathVariable("id") Long id) {
        return personService.findPersonById(id);
    }

    /**
     * Get score of person by id
     * @param personId id
     * @return score
     */
    @GetMapping(path = "score/{personId}")
    public Optional<Score> findScorePersonById(@PathVariable("personId") Long personId) {
        return personService.findPersonScoreById(personId);
    }

    @PostMapping(path = "register")
    @SuppressWarnings("squid:S4684") // @Valid will validate the person.
    public void registerNewPerson(@Valid @RequestBody Person person) {
        personService.addNewPerson(person);
    }

    /**
     * Update/save existing person
     * @param person Person to be saved
     */
    @PostMapping(path = "save")
    @SuppressWarnings("squid:S4684") // @Valid will validate the person.
    public void savePerson(@Valid @RequestBody Person person) {
        personService.savePerson(person);
    }

    /**
     * Delete a person out of the database
     * @param personId id
     */
    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }
}
