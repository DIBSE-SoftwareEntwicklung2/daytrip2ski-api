package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service of class person
 */
@Service
@Validated
public class PersonService {
    private final PersonRepository personRepository;

    /**
     * Constructor
     * @param personRepository repository of persons
     */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Get all persons
     * @return list of persons
     */
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    /**
     * Search a people with that id
     * and throws an exception if it not found
     *
     * @param id id
     * @return Person
     * @throws IllegalStateException Person not found
     */
    public Optional<Person> findPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) {
            throw new IllegalStateException("Person not found");
        }
        return personOptional;
    }

    /**
     * Search for a people with that email
     * and throws an exception if it not found
     *
     * @param email email
     * @return Person
     * @throws IllegalStateException Person with email not found
     */
    public Optional<Person> findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }

    /**
     * Gives the score of a person with that id
     * and throws an exception if it not found
     *
     * @param id id
     * @return Score
     * @throws IllegalStateException Person has no scoring
     */
    public Optional<Score> findPersonScoreById(Long id) {
        Optional<Score> scoreOptional = personRepository.findPersonScoreById(id);
        if (scoreOptional.isEmpty()) {
            throw new IllegalStateException("Person has no scoring");
        }
        return scoreOptional;
    }

    /**
     * Add a new person to the database and
     * checks if a person already exists
     *
     * @param person person
     * @throws IllegalStateException Person already exists or Person has birthday in the future
     */
    @Transactional
    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        if (person.getDob().isBefore(LocalDate.now().minusYears(100L)) || person.getDob().isAfter(LocalDate.now().minusYears(1L))) {
            throw new IllegalStateException("Date of Birth not in range");
        }
        personRepository.save(person);
    }

    /**
     * Saved an existing person
     *
     * @param person person
     */
    @Transactional
    public void savePerson(Person person) {
        this.findPersonById(person.getId());
        personRepository.save(person);
    }

    /**
     * Delete a person with that id and check if
     * that person exists
     *
     * @param id id
     * @throws IllegalStateException Person does not exist
     */
    @Transactional
    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new IllegalStateException("Person with id " + id + " does not exists");
        }
        personRepository.deleteById(id);
    }
}
