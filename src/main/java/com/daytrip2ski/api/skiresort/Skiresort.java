package com.daytrip2ski.api.skiresort;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Skiresort {
    private static String actualWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=#latitude#&lon=#longitude#&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d";
    private static String forecastWeatherUrl = "https://api.openweathermap.org/data/2.5/forecast/daily?lat=#latitude#&lon=#longitude#&cnt=10&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d";
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

    private Long numberOfCogRailway = 0L;

    private Long numberOfFunicular = 0L;

    private Long numberOfCableCar = 0L;

    private Long numberOfGondolaLift = 0L;

    private Long numberOfChairLift = 0L;

    private Long numberOfTBarLift = 0L;

    private Long numberOfBabyLift = 0L;

    private Long numberOfMovingCarpet = 0L;

    private Long totalNumbersOfClimbingAids;

    private Long distanceEasy = 0L;

    private Long distanceIntermediate = 0L;

    private Long distanceDifficult = 0L;

    @Column(updatable = false)
    private Long totalSlopeDistance;

    private String generalSnowCondition;

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

    private Double priceDayTicketAdults;

    private Double priceDayTicketYouth;

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

    public Skiresort(String name,
                     Double latitude, Double longitude,
                     Long altitudeValley, Long altitudeMountain,
                     Long numberOfCogRailway, Long numberOfFunicular,
                     Long numberOfCableCar, Long numberOfGondolaLift,
                     Long numberOfChairLift, Long numberOfTBarLift,
                     Long numberOfBabyLift, Long numberOfMovingCarpet,
                     Long distanceEasy, Long distanceIntermediate,
                     Long distanceDifficult,
                     String generalSnowCondition, Long numberOfRestaurants,
                     String webcamUrl, String websiteUrl,
                     Boolean skiRental, Boolean skiCourse,
                     Boolean familyFriendly, Double priceDayTicketAdults,
                     Double priceDayTicketYouth, Double priceDayTicketChildren,
                     LocalDate seasonFrom, LocalDate seasonTo,
                     LocalTime openingHoursFrom, LocalTime openingHoursTo,
                     String openingHoursNote, String remark,
                     String description, Boolean isActive) {
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

    public String getWeatherActualUrl() {
        String returnUrl = actualWeatherUrl;
        returnUrl = returnUrl.replace("#longitude#", this.longitude.toString());
        returnUrl = returnUrl.replace("#latitude#", this.latitude.toString());

        return returnUrl;
    }

    public String getWeatherForecastUrl() {
        String returnUrl = forecastWeatherUrl;
        returnUrl = returnUrl.replace("#longitude#", this.longitude.toString());
        returnUrl = returnUrl.replace("#latitude#", this.latitude.toString());

        return returnUrl;
    }

    public Long getTotalSlopeDistance() {
        return this.distanceEasy + this.distanceIntermediate + this.distanceDifficult;
    }

    public void setTotalNumbersOfClimbingAids() {
        this.totalNumbersOfClimbingAids = this.numberOfBabyLift + this.numberOfChairLift + this.numberOfGondolaLift
                + this.numberOfCableCar + this.numberOfFunicular + this.numberOfCogRailway
                + this.numberOfMovingCarpet + this.numberOfTBarLift;
    }

    @PrePersist
    @PreUpdate
    public void calculateTotalNumbersOfClimbingAids() {
        this.setTotalNumbersOfClimbingAids();
    }
}
