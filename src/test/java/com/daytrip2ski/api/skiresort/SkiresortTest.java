package com.daytrip2ski.api.skiresort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

class SkiresortTest {
    @Test
    void createSkiresortSuccessful() {
        var skiresort = new Skiresort("KitzSki", 47.444990D, 12.391430D, 800L, 2000L,
                2L, 3L, 1L, 22L, 27L, 9L, 1L, 8L,
                102L, 66L, 20L, "hard", 37L,
                "https://www.kitzski.at/de/bergurlaub-tirol/webcams.html",
                "https://www.kitzski.at/",
                true, true, true, 59.5D, 44D, 29.5D,
                LocalDate.of(2022, Month.OCTOBER, 29), LocalDate.of(2023, Month.APRIL, 16),
                LocalTime.of(8, 30), LocalTime.of(16, 0),
                "The openening times are provided by the ski resort KitzSki – Kitzbühel/\u200BKirchberg and can vary based on external conditions, day of the week, school holidays and public holidays.",
                "TestRemark",
                "The ski resort KitzSki – Kitzbühel/\u200BKirchberg is located in Kitzbühel (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbühel (District)) and in the Brixental (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbüheler Alpen). For skiing and snowboarding, there are 188 km of slopes and 45 km of ski routes available. 57 lifts transport the guests. The winter sports area is situated between the elevations of 800 and 2,000 m.",
                true);
        Assertions.assertEquals("KitzSki", skiresort.getName());
        Assertions.assertEquals(47.444990D, skiresort.getLatitude());
        Assertions.assertEquals(12.391430D, skiresort.getLongitude());
        Assertions.assertEquals(800L, skiresort.getAltitudeValley());
        Assertions.assertEquals(2000L, skiresort.getAltitudeMountain());
        Assertions.assertEquals(2L, skiresort.getNumberOfCogRailway());
        Assertions.assertEquals(3L, skiresort.getNumberOfFunicular());
        Assertions.assertEquals(1L, skiresort.getNumberOfCableCar());
        Assertions.assertEquals(22L, skiresort.getNumberOfGondolaLift());
        Assertions.assertEquals(27L, skiresort.getNumberOfChairLift());
        Assertions.assertEquals(9L, skiresort.getNumberOfTBarLift());
        Assertions.assertEquals(1L, skiresort.getNumberOfBabyLift());
        Assertions.assertEquals(8L, skiresort.getNumberOfMovingCarpet());
        Assertions.assertEquals(102L, skiresort.getDistanceEasy());
        Assertions.assertEquals(66L, skiresort.getDistanceIntermediate());
        Assertions.assertEquals(20L, skiresort.getDistanceDifficult());
        Assertions.assertEquals("hard", skiresort.getGeneralSnowCondition());
        Assertions.assertEquals(37L, skiresort.getNumberOfRestaurants());
        Assertions.assertEquals("https://www.kitzski.at/de/bergurlaub-tirol/webcams.html", skiresort.getWebcamUrl());
        Assertions.assertEquals("https://www.kitzski.at/", skiresort.getWebsiteUrl());
        Assertions.assertEquals(true, skiresort.getSkiRental());
        Assertions.assertEquals(true, skiresort.getSkiCourse());
        Assertions.assertEquals(true, skiresort.getFamilyFriendly());
        Assertions.assertEquals(59.5D, skiresort.getPriceDayTicketAdults());
        Assertions.assertEquals(44D, skiresort.getPriceDayTicketYouth());
        Assertions.assertEquals(29.5D, skiresort.getPriceDayTicketChildren());
        Assertions.assertEquals(LocalDate.of(2022, Month.OCTOBER, 29), skiresort.getSeasonFrom());
        Assertions.assertEquals(LocalDate.of(2023, Month.APRIL, 16), skiresort.getSeasonTo());
        Assertions.assertEquals(LocalTime.of(8, 30), skiresort.getOpeningHoursFrom());
        Assertions.assertEquals(LocalTime.of(16, 0), skiresort.getOpeningHoursTo());
        Assertions.assertEquals("The openening times are provided by the ski resort KitzSki – Kitzbühel/\u200BKirchberg and can vary based on external conditions, day of the week, school holidays and public holidays.", skiresort.getOpeningHoursNote());
        Assertions.assertEquals("TestRemark", skiresort.getRemark());
        Assertions.assertEquals("The ski resort KitzSki – Kitzbühel/\u200BKirchberg is located in Kitzbühel (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbühel (District)) and in the Brixental (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbüheler Alpen). For skiing and snowboarding, there are 188 km of slopes and 45 km of ski routes available. 57 lifts transport the guests. The winter sports area is situated between the elevations of 800 and 2,000 m.", skiresort.getDescription());
        Assertions.assertEquals(true, skiresort.getIsActive());
    }

    @Test
    void createSkiresortConstraints() {
        var skiresort = new Skiresort();
        String stringBufferSuccess = "A".repeat(1024);
        String stringFail = "A".repeat(1026);

        skiresort.setWebcamUrl(stringBufferSuccess);
        skiresort.setWebsiteUrl(stringBufferSuccess);

        Assertions.assertEquals(stringBufferSuccess, skiresort.getWebcamUrl());
        Assertions.assertEquals(stringBufferSuccess, skiresort.getWebsiteUrl());

        // ToDo

        /*Exception ex = assertThrows(Exception.class, () -> {
            skiresort.setWebcamUrl(stringFail);
        });

        ex = assertThrows(Exception.class, () -> {
            skiresort.setWebsiteUrl(stringFail);
        });*/
    }

    @Test
    void GetWeatherActualUrl() {
        var skiresort = new Skiresort();
        skiresort.setLatitude(45D);
        skiresort.setLongitude(55D);

        var weatherUrl = skiresort.getWeatherActualUrl();

        Assertions.assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=45.0&lon=55.0&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d", weatherUrl);
    }

    @Test
    void GetForecastWeatherActualUrl() {
        var skiresort = new Skiresort();
        skiresort.setLatitude(45D);
        skiresort.setLongitude(55D);

        var forecastWeatherUrl = skiresort.getWeatherForecastUrl();

        Assertions.assertEquals("https://api.openweathermap.org/data/2.5/forecast/daily?lat=45.0&lon=55.0&cnt=10&units=metric&appid=27c73d44b5a87c8738cbe79bc5eca26d", forecastWeatherUrl);
    }
}
