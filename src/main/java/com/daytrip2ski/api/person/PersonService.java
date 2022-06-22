package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(@Valid Person person) {
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
}
