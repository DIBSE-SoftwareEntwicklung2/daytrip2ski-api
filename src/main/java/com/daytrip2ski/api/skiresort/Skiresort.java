package com.daytrip2ski.api.skiresort;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Skiresort {
    @Id
    @SequenceGenerator(
            name = "skiresort_seq",
            sequenceName = "skiresort_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "skiresort_seq"
    )
    private Long id;
    private String name;
    private Long latitude;
    private Long longitude;
    private Long altitudeValley;
    private Long altitudeMountain;
    private Long numberOfLifts;
    private String difficulty;
    private Long totalSkiSlopeDistance;
    private String generalSnowCondition;
    private Long numberOfRestaurants;
    private String webcamUrl;
    private String websiteUrl;
    private Boolean skiRent;
    private Boolean skiingLessons;
    private Boolean familyFriendly;
    private String remark;
    private String description;

    @OneToMany(
            mappedBy = "skiresort",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<OpeningHours> openingHours = new HashSet<>();

    @OneToMany(
            mappedBy = "skiresort",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<SkiSlope> skiSlope = new HashSet<>();
    private Boolean isActive;
}
