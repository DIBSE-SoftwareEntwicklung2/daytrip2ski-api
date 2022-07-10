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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @InjectMocks
    PersonService personService;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personService = new PersonService(personRepository);
    }

    @Test
    void getPersons() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        when(personRepository.findAll()).thenReturn(persons);
        List<Person> allPersons = personService.getPersons();

        assertEquals(1, allPersons.size());
        assertEquals(person, allPersons.get(0));
    }

    @Test
    void getPersonById() {
        Optional<Person> person = Optional.of(new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9));
        when(personRepository.findById(1L)).thenReturn(person);
        Optional<Person> person1 = personService.findPersonById(1L);

        assertEquals(person, person1);
    }

    @Test
    void getPersonByIdNotFound() {
        Optional<Person> person = Optional.of(new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9));
        when(personRepository.findById(1L)).thenReturn(person);
        Exception ex = assertThrows(IllegalStateException.class, () -> personService.findPersonById(2L));

        assertEquals("Person not found", ex.getMessage());
    }

    @Test
    void getPersonScoreById() {
        Optional<Score> score = Optional.of(new Score(1L, 2d, 3d, 4d,5d,true,true,6d,7d, 8d));
        when(personRepository.findPersonScoreById(1L)).thenReturn(score);
        Optional<Score> score1 = personService.findPersonScoreById(1L);

        assertEquals(score, score1);
    }

    @Test
    void findPersonByEmail() {
        Optional<Person> person = Optional.of(new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9));
        when(personRepository.findPersonByEmail("max.mustermann@test.com")).thenReturn(person);
        Optional<Person> person1 = personService.findPersonByEmail("max.mustermann@test.com");

        assertEquals(person, person1);
    }

    @Test
    void getPersonScoreByIdNoScore() {
        Optional<Score> score = Optional.of(new Score(1L, 2d, 3d, 4d,5d,true,true,6d,7d, 8d));
        when(personRepository.findPersonScoreById(1L)).thenReturn(score);
        Exception ex = assertThrows(IllegalStateException.class, () -> personService.findPersonScoreById(2L));

        assertEquals("Person has no scoring", ex.getMessage());
    }

    @Test
    void addNewPersonSuccessful() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        personService.addNewPerson(person);
        verify(personRepository, times(1)).save(person);
    }

    @Test
    void addNewPersonEmailExists() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        when(personRepository.findPersonByEmail(person.getEmail())).thenReturn(Optional.of(person));
        Exception ex = assertThrows(IllegalStateException.class, () -> personService.addNewPerson(person));

        assertEquals("Email already exists", ex.getMessage());
    }

    @Test
    void addNewPersonDayOfBirth() {
        Person personFail1 = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().minusYears(101), 7.8, 8.9);
        Person personFail2 = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now(), 7.8, 8.9);
        Person personSuccess1 = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().minusYears(99), 7.8, 8.9);
        Person personSuccess2 = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().minusYears(2), 7.8, 8.9);

        personService.addNewPerson(personSuccess1);
        personService.addNewPerson(personSuccess2);
        Exception ex = assertThrows(IllegalStateException.class, () -> personService.addNewPerson(personFail1));
        Exception ex2 = assertThrows(IllegalStateException.class, () -> personService.addNewPerson(personFail2));

        verify(personRepository, times(1)).save(personSuccess1);
        verify(personRepository, times(1)).save(personSuccess2);
        assertEquals("Date of Birth not in range", ex.getMessage());
        assertEquals("Date of Birth not in range", ex2.getMessage());
    }

    @Test
    void savePerson() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        person.setId(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        personService.savePerson(person);
        verify(personRepository, times(1)).save(person);
    }

    @Test
    void savePersonNotFound() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        person.setId(2L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        Exception ex = assertThrows(IllegalStateException.class, () -> personService.savePerson(person));
        assertEquals("Person not found", ex.getMessage());
    }

    @Test
    void deletePersonSuccess() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        when(personRepository.existsById(person.getId())).thenReturn(true);
        personService.deletePerson(person.getId());
        verify(personRepository, times(1)).deleteById(person.getId());
    }

    @Test
    void deletePersonNotExists() {
        Person person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        var id = person.getId();
        when(personRepository.existsById(person.getId())).thenReturn(false);
        assertThrows(IllegalStateException.class, () -> personService.deletePerson(id));
    }
}