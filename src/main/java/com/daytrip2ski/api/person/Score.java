package com.daytrip2ski.api.person;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * This Class is the Model of a Score and define the columns for the
 * Database
 * Lombok is used for automatic generating Getter and Setter and other
 * class stuff
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Score {
    @Id
    @SequenceGenerator(name = "score_seq", sequenceName = "score_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq")
    private Long id;
    @Min(0)
    @Max(1)
    private Double variety;
    @Min(0)
    @Max(1)
    private Double affinityToEasyTracks;
    @Min(0)
    @Max(1)
    private Double affinityToIntermediateTracks;
    @Min(0)
    @Max(1)
    private Double affinityToDifficultTracks;
    private Boolean requiresRental;
    private Boolean requiresFamilyFriendly;
    @Min(0)
    private Double budged;
    @Min(0)
    private Double maxDistance;
    @Min(0)
    private Double maxDrivingTime;

    /**
     * Smaller constructor without id
     * @param variety variety
     * @param affinityToEasyTracks affinityToEasyTracks
     * @param affinityToIntermediateTracks affinityToIntermediateTracks
     * @param affinityToDifficultTracks affinityToDifficultTracks
     * @param requiresRental requiresRental
     * @param requiresFamilyFriendly requiresFamilyFriendly
     * @param budged budged
     * @param maxDistance maxDistance
     * @param maxDrivingTime maxDrivingTime
     */
    public Score(Double variety, Double affinityToEasyTracks, Double affinityToIntermediateTracks, Double affinityToDifficultTracks, Boolean requiresRental, Boolean requiresFamilyFriendly, Double budged, Double maxDistance, Double maxDrivingTime) {
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
