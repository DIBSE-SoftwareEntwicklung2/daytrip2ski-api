package com.daytrip2ski.api.skiresort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This Class is the Model of a Skiresort and define the columns for the
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
public class Skiresort {
    /**
     * Base URL for generating API URLs for openweather API
     */
    private static String actualWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=#latitude#&lon=#longitude#&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d";
    private static String forecastWeatherUrl = "https://api.openweathermap.org/data/2.5/forecast/daily?lat=#latitude#&lon=#longitude#&cnt=10&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d";
    @Id
    @SequenceGenerator(name = "skiresort_seq", sequenceName = "skiresort_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skiresort_seq")
    @Column(updatable = false)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String name;

    @NotNull(message = "GPS coordinate required")
    @Column(nullable = false)
    private Double latitude;

    @NotNull(message = "GPS coordinate required")
    @Column(nullable = false)
    private Double longitude;

    private Long altitudeValley;

    private Long altitudeMountain;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfCogRailway = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfFunicular = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfCableCar = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfGondolaLift = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfChairLift = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfTBarLift = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfBabyLift = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfMovingCarpet = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long totalNumbersOfClimbingAids;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long distanceEasy = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long distanceIntermediate = 0L;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long distanceDifficult = 0L;

    @Column(updatable = false)
    private Long totalSlopeDistance;

    private String generalSnowCondition;

    @PositiveOrZero(message = "Negative values not allowed")
    private Long numberOfRestaurants;

    @Column(length = 1024)
    private String webcamUrl;

    @Column(length = 1024)
    private String websiteUrl;

    @Transient
    private String weatherActualUrl;

    @Transient
    private String weatherForecastUrl;

    private Boolean skiRental;

    private Boolean skiCourse;

    private Boolean familyFriendly;

    @Positive(message = "Negative or 0 values not allowed")
    private Double priceDayTicketAdults;

    @Positive(message = "Negative or 0 values not allowed")
    private Double priceDayTicketYouth;

    @Positive(message = "Negative or 0 values not allowed")
    private Double priceDayTicketChildren;

    private LocalDate seasonFrom;

    private LocalDate seasonTo;

    private LocalTime openingHoursFrom;

    private LocalTime openingHoursTo;

    @Lob
    private String openingHoursNote;

    @Lob
    private String remark;

    @Lob
    private String description;

    private Boolean isActive;

    /**
     * Constructor
     */
    public Skiresort(String name, Double latitude, Double longitude, Long altitudeValley, Long altitudeMountain, Long numberOfCogRailway, Long numberOfFunicular, Long numberOfCableCar, Long numberOfGondolaLift, Long numberOfChairLift, Long numberOfTBarLift, Long numberOfBabyLift, Long numberOfMovingCarpet, Long distanceEasy, Long distanceIntermediate, Long distanceDifficult, String generalSnowCondition, Long numberOfRestaurants, String webcamUrl, String websiteUrl, Boolean skiRental, Boolean skiCourse, Boolean familyFriendly, Double priceDayTicketAdults, Double priceDayTicketYouth, Double priceDayTicketChildren, LocalDate seasonFrom, LocalDate seasonTo, LocalTime openingHoursFrom, LocalTime openingHoursTo, String openingHoursNote, String remark, String description, Boolean isActive) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeValley = altitudeValley;
        this.altitudeMountain = altitudeMountain;
        this.numberOfCogRailway = numberOfCogRailway;
        this.numberOfFunicular = numberOfFunicular;
        this.numberOfCableCar = numberOfCableCar;
        this.numberOfGondolaLift = numberOfGondolaLift;
        this.numberOfChairLift = numberOfChairLift;
        this.numberOfTBarLift = numberOfTBarLift;
        this.numberOfBabyLift = numberOfBabyLift;
        this.numberOfMovingCarpet = numberOfMovingCarpet;
        this.distanceEasy = distanceEasy;
        this.distanceIntermediate = distanceIntermediate;
        this.distanceDifficult = distanceDifficult;
        this.generalSnowCondition = generalSnowCondition;
        this.numberOfRestaurants = numberOfRestaurants;
        this.webcamUrl = webcamUrl;
        this.websiteUrl = websiteUrl;
        this.skiRental = skiRental;
        this.skiCourse = skiCourse;
        this.familyFriendly = familyFriendly;
        this.priceDayTicketAdults = priceDayTicketAdults;
        this.priceDayTicketYouth = priceDayTicketYouth;
        this.priceDayTicketChildren = priceDayTicketChildren;
        this.seasonFrom = seasonFrom;
        this.seasonTo = seasonTo;
        this.openingHoursFrom = openingHoursFrom;
        this.openingHoursTo = openingHoursTo;
        this.openingHoursNote = openingHoursNote;
        this.remark = remark;
        this.description = description;
        this.isActive = isActive;
    }

    /**
     * Generate API URL for actual openweather API
     *
     * @return Openweather URL
     */
    public String getWeatherActualUrl() {
        String returnUrl = actualWeatherUrl;
        returnUrl = returnUrl.replace("#longitude#", this.longitude.toString());
        returnUrl = returnUrl.replace("#latitude#", this.latitude.toString());

        return returnUrl;
    }

    /**
     * Generate API URL for forecase openweather API
     *
     * @return Openweather URL
     */
    public String getWeatherForecastUrl() {
        String returnUrl = forecastWeatherUrl;
        returnUrl = returnUrl.replace("#longitude#", this.longitude.toString());
        returnUrl = returnUrl.replace("#latitude#", this.latitude.toString());

        return returnUrl;
    }

    /**
     * Calculate the total slope distance in km of all categories
     *
     * @return distance in km
     */
    public Long getTotalSlopeDistance() {
        return this.distanceEasy + this.distanceIntermediate + this.distanceDifficult;
    }

    /**
     * Set the total number of climbing aids
     */
    private void setTotalNumbersOfClimbingAids() {
        this.totalNumbersOfClimbingAids = this.numberOfBabyLift + this.numberOfChairLift + this.numberOfGondolaLift + this.numberOfCableCar + this.numberOfFunicular + this.numberOfCogRailway + this.numberOfMovingCarpet + this.numberOfTBarLift;
    }

    /**
     * Calculate total number of climbing aids before persisting
     */
    @PrePersist
    @PreUpdate
    public void calculateTotalNumbersOfClimbingAids() {
        this.setTotalNumbersOfClimbingAids();
    }
}
