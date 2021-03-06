package com.daytrip2ski.api.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Testing person controller
 */
class PersonControllerTest {
    @InjectMocks
    PersonController personController;
    @Mock
    PersonService personService;

    /**
     * Set up before each test
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personController = new PersonController(personService);
    }

    /**
     * Get person
     */
    @Test
    void getPersons() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        when(personService.getPersons()).thenReturn(persons);
        List<Person> allPersons = personController.getPersons();

        assertEquals(1, allPersons.size());
        assertEquals(person, allPersons.get(0));
    }

    /**
     * Find person by id
     */
    @Test
    void findPersonById() {
        Optional<Person> person = Optional.of(new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9));
        when(personService.findPersonById(1L)).thenReturn(person);
        Optional<Person> person1 = personController.findPersonById(1L);
        assertEquals(person, person1);
    }

    /**
     * Find score of person by id
     */
    @Test
    void findScorePersonById() {
        Optional<Score> score = Optional.of(new Score(1L, 2d, 3d, 4d,5d,true,true,6d,7d, 8d));
        when(personService.findPersonScoreById(1L)).thenReturn(score);
        Optional<Score> score1 = personController.findScorePersonById(1L);
        assertEquals(score, score1);
    }

    /**
     * Add a new person
     */
    @Test
    void addNewPerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personController.registerNewPerson(person);
        verify(personService, times(1)).addNewPerson(person);
    }

    /**
     * Add a new invalid person
     */
    @Test
    void addNewPersonFail() {
        Person person = new Person("Max", "", "max.mustermanntest.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personController.registerNewPerson(person);
        verify(personService, times(1)).addNewPerson(person);
    }

    /**
     * Update/save a person
     */
    @Test
    void savePerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personController.savePerson(person);
        verify(personService, times(1)).savePerson(person);
    }

    /**
     * Update/save an invalid person
     */
    @Test
    void savePersonFail() {
        Person person = new Person("Max", "", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personController.savePerson(person);
        verify(personService, times(1)).savePerson(person);
    }

    /**
     * Delete a person
     */
    @Test
    void deletePerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personController.deletePerson(person.getId());
        verify(personService, times(1)).deletePerson(person.getId());
    }
}
