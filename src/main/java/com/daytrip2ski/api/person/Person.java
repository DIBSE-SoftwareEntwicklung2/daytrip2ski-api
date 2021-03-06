package com.daytrip2ski.api.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

/**
 * This Class is the Model of a Person and define the columns for the
 * Database
 * Lombok is used for automatic generating Getter and Setter and other
 * class stuff
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "First Name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Not a valid E-Mail address")
    @NotBlank(message = "E-Mail is required")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;

    @NotNull(message = "Home position required")
    @Column(name = "home_latitude", nullable = false)
    private Double homeLatitude;

    @NotNull(message = "Home position required")
    @Column(name = "home_longitude", nullable = false)
    private Double homeLongitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "person_score_fk"))

    @Valid
    private Score score;

    @Transient
    private Integer age;

    /**
     * Smaller Constructor without id and Score object
     *
     * @param firstName     first name
     * @param lastName      last name
     * @param email         email
     * @param dob           day of birth
     * @param homeLatitude  home location latitude
     * @param homeLongitude home location longitude
     */
    public Person(String firstName, String lastName, String email, LocalDate dob, Double homeLatitude, Double homeLongitude) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.homeLatitude = homeLatitude;
        this.homeLongitude = homeLongitude;
    }

    /**
     * Smaller Constructor without id
     *
     * @param firstName     first name
     * @param lastName      last name
     * @param email         email
     * @param dob           day of birth
     * @param homeLatitude  home location latitude
     * @param homeLongitude home location longitude
     * @param score         score
     */
    public Person(String firstName, String lastName, String email, LocalDate dob, Double homeLatitude, Double homeLongitude, Score score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.homeLatitude = homeLatitude;
        this.homeLongitude = homeLongitude;
        this.score = score;
    }

    /**
     * Calculate the actual age
     *
     * @return actual age
     */
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
