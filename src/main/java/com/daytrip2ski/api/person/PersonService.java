package com.daytrip2ski.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<Person> personOptional = personRepository.findStudentByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
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
