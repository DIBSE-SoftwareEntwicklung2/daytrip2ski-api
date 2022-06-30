package com.daytrip2ski.api.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonControllerTest {
    @InjectMocks
    PersonController personController;
    @Mock
    PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personController = new PersonController(personService);
    }

    @Test
    void getPersons() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        when(personService.getPersons()).thenReturn(persons);
        List<Person> allPersons = personController.getPersons();

        assertEquals(1, allPersons.size());
        assertEquals(person, allPersons.get(0));
    }

    @Test
    void addNewPerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        personController.registerNewPerson(person);
        verify(personService, times(1)).addNewPerson(person);
    }

    @Test
    void addNewPersonFail() {
        Person person = new Person("Max", "", "max.mustermanntest.com", LocalDate.of(1999, 1, 8));
        personController.registerNewPerson(person);
        verify(personService, times(1)).addNewPerson(person);
    }

    @Test
    void deletePerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        personController.deletePerson(person.getId());
        verify(personService, times(1)).deletePerson(person.getId());
    }
}
