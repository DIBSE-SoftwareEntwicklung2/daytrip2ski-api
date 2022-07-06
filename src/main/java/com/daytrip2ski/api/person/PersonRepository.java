package com.daytrip2ski.api.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * SQL repository for person
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByEmail(String email);

    @Query("SELECT p.score FROM Person p WHERE p.id = :personId")
    Optional<Score> findPersonScoreById(@Param("personId") Long personId);
}
