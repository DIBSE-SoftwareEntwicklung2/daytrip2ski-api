package com.daytrip2ski.api.person;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_seq",
            sequenceName = "person_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_seq"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Person(String firstName,
                  String lastName,
                  String email,
                  LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    };

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
