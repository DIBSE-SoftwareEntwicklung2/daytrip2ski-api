package com.daytrip2ski.api.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

class PersonTest {
    @Test
    void createPersonSuccessful() {
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        Assertions.assertEquals("Max", person.getFirstName());
        Assertions.assertEquals("Mustermann", person.getLastName());
        Assertions.assertEquals("max.mustermann@test.com", person.getEmail());
        Assertions.assertEquals(LocalDate.of(1999, 1, 8), person.getDob());
    }

    @Test
    void createPersonSuccessfulWithScore() {
        var score = new Score(1l, 0d, 0d, 0d,0d,false,false,0d,0d, 0d);
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8), score);
        Assertions.assertEquals("Max", person.getFirstName());
        Assertions.assertEquals("Mustermann", person.getLastName());
        Assertions.assertEquals("max.mustermann@test.com", person.getEmail());
        Assertions.assertEquals(LocalDate.of(1999, 1, 8), person.getDob());
        Assertions.assertEquals(score, person.getScore());
    }

    /*@Test
    public void createPersonFailing() {
        // Wrong Email
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermanntest.com", LocalDate.of(1999, 1, 8));
        });
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermann@testcom", LocalDate.of(1999, 1, 8));
        });

        // Empty name
        assertThrows(Exception.class, () -> {
            new Person("", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        });
        assertThrows(Exception.class, () -> {
            new Person("Max", "", "max.mustermann@test.com", LocalDate.of(1999, 1, 8));
        });

        // Wrong Birthday
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.now().plusDays(1));
        });
        assertThrows(Exception.class, () -> {
            new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 2, 29));
        });
    }*/

    // ToDo
    /*@Test
    public void getPersonsAge() {
        // Arrange
        var person = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 12));
        var person2 = new Person("Max", "Mustermann", "max.mustermann@test.com", LocalDate.of(1999, 1, 14));

        // Act
        var actualAge = person.getAge();
        var actualAge2 = person2.getAge();

        // Assert
        Assertions.assertEquals(21, actualAge);
        Assertions.assertEquals(20, actualAge2);
    }*/
}
