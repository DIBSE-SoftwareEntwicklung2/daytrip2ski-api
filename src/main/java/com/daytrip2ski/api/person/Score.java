package com.daytrip2ski.api.person;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Score {
    @Id
    @SequenceGenerator(
            name = "score_seq",
            sequenceName = "score_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "score_seq"
    )
    private Long id;
    private Double variety;
    private Double affinityToEasyTracks;
    private Double affinityToIntermediateTracks;
    private Double affinityToDifficultTracks;
    private Boolean requiresRental;
    private Boolean requiresFamilyFriendly;
    private Double budged;
    private Double maxDistance;
    private Double maxDrivingTime;

    public Score(Double variety,
                 Double affinityToEasyTracks,
                 Double affinityToIntermediateTracks,
                 Double affinityToDifficultTracks,
                 Boolean requiresRental,
                 Boolean requiresFamilyFriendly,
                 Double budged,
                 Double maxDistance,
                 Double maxDrivingTime) {
        this.variety = variety;
        this.affinityToEasyTracks = affinityToEasyTracks;
        this.affinityToIntermediateTracks = affinityToIntermediateTracks;
        this.affinityToDifficultTracks = affinityToDifficultTracks;
        this.requiresRental = requiresRental;
        this.requiresFamilyFriendly = requiresFamilyFriendly;
        this.budged = budged;
        this.maxDistance = maxDistance;
        this.maxDrivingTime = maxDrivingTime;
    }
}
