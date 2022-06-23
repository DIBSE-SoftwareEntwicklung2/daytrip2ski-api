package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        if (person.getDob().isBefore(LocalDate.now().minusYears(100L)) ||
                person.getDob().isAfter(LocalDate.now().minusYears(1L))) {
            throw new IllegalStateException("Date of Birth not in range");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        if (!personRepository.existsById(personId)) {
            throw new IllegalStateException(
                    "Person with id " + personId + " does not exists"
            );
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Person person) {

    }

    // Code Smell
    private int sonarcloudFindings(boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, boolean flag6, boolean flag7, boolean flag8) {
        // Bug
        boolean flag = false;
        if (flag) {
            personRepository.deleteById(1L);
        }
        else {
            throw new IllegalStateException(
                    "Person with id " + 1 + " does not exists"
            );
        }

        // Vulnerability
        // NonCompliant
        SecureRandom sr = new SecureRandom();
        sr.setSeed(123456L);
        sr.nextInt(32);

        // Compliant
        SecureRandom srCompliant = new SecureRandom();
        srCompliant.nextInt(32);

        // Code smell
        if (flag1) {
            return 1;
        }
        else if (flag2 && flag3) {
            return 23;
        }
        else if (flag4) {
            if (flag8) {
                return 8;
            }
            else {
                return 4;
            }
        }
        else if (flag2 && flag5) {
            if (flag8) {
                return 8;
            }
            else {
                return 25;
            }
        }
        else if (flag2 && flag6) {
            if (flag7) {
                return 7;
            }
            else {
                return 26;
            }
        }
        else if (flag6) {
            return 6;
        }
        else {
            return 0;
        }
    }
}
