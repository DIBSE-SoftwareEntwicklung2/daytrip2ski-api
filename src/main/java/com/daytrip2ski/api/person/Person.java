package com.daytrip2ski.api.person;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
@Validated
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
    @NotBlank(message="First Name is required")
    private String firstName;
    @NotBlank(message="Last Name is required")
    private String lastName;
    @Email(message="Not a valid E-Mail address")
    @NotBlank(message="E-Mail is required")
    private String email;
    @NotNull
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "score_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "person_score_fk"
            )
    )

    @Valid
    private Score score;

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

    public Person(String firstName,
                  String lastName,
                  String email,
                  LocalDate dob,
                  Score score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.score = score;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
