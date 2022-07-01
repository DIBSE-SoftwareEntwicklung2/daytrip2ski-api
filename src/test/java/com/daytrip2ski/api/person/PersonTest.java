package com.daytrip2ski.api.person;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.Period;

class PersonTest {
    private static Validator validator;
    @BeforeAll
    public static void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void createPersonSuccessful() {
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        Assertions.assertEquals("Max", person.getFirstName());
        Assertions.assertEquals("Mustermann", person.getLastName());
        Assertions.assertEquals("max.mustermann@test.com", person.getEmail());
        Assertions.assertEquals(LocalDate.of(1999, 1, 8), person.getDob());
        Assertions.assertEquals(null, person.getScore());

        var violations = validator.validate(person);
        Assertions.assertTrue(violations.isEmpty(), violations.toString());
    }

    @Test
    void createPersonSuccessfulWithScore() {
        var score = new Score(1l, 0d, 0d, 0d,0d,false,false,0d,0d, 0d);
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9, score);
        Assertions.assertEquals("Max", person.getFirstName());
        Assertions.assertEquals("Mustermann", person.getLastName());
        Assertions.assertEquals("max.mustermann@test.com", person.getEmail());
        Assertions.assertEquals(LocalDate.of(1999, 1, 8), person.getDob());
        Assertions.assertEquals(score, person.getScore());

        var  violations = validator.validate(person);
        Assertions.assertTrue(violations.isEmpty(), violations.toString());
    }

    @Test
    public void createPersonWrongEmail() {
        var person = new Person("Max", "Mustermann", "max.mustermanntest.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        var violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 1, "Only Email should be invalid: " + violations);
        var first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "Not a valid E-Mail address");
    }

    @Test
    public void createPersonWrongFirstName() {
        var person = new Person("", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        var violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 1, "Only FirstName should be invalid: " + violations);
        var first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "First Name is required");
    }

    @Test
    public void createPersonWrongLastName() {
        var person = new Person("Max", "", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), 7.8, 8.9);
        var violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 1, "Only LastName should be invalid: " + violations);
        var first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "Last Name is required");
    }

    @Test
    public void createPersonNoHomePosition() {
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        var violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 2, "Only home positions should be invalid: " + violations);
        var first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "Homepositon required");
        var second = violations.iterator().next();
        Assertions.assertEquals(second.getMessage(), "Homepositon required");
    }

    /*@Test
    public void createPersonDayOfBirth() {
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 2, 29));
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 1);
        var first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "Not a valid E-Mail address");

        person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().plusDays(1));
        violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(violations.size(), 1);
        first = violations.iterator().next();
        Assertions.assertEquals(first.getMessage(), "Not a valid E-Mail address");
    }*/


        /*// Wrong Birthday
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().plusDays(1));
        });
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 2, 29));
        });*/

    @Test
    public void getPersonsAge() {
        // Arrange
        var date = LocalDate.now().minusYears(20).minusDays(1);
        var date2 = LocalDate.now().minusYears(20).plusDays(1);
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", date);
        var person2 = new Person("Max", "Mustermann", "max.mustermann@test.com", date2);

        // Act
        var actualAge = person.getAge();
        var actualAge2 = person2.getAge();

        var expectedAge = Period.between(date, LocalDate.now()).getYears();
        var expectedAge2 = Period.between(date2, LocalDate.now()).getYears();

        // Assert
        Assertions.assertEquals(expectedAge, actualAge);
        Assertions.assertEquals(expectedAge2, actualAge2);
    }
}
