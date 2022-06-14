package com.daytrip2ski.api.skiresort;

import com.daytrip2ski.api.person.Person;
import com.daytrip2ski.api.person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class SkiresortConfig {

    @Bean
    CommandLineRunner insertSkiresorts(SkiresortRepository repository) {
        return args -> {
            Skiresort kitzski = new Skiresort("KitzSki", null, null, 800L, 2000L,
                   0L, 1L, 22L, 27L, 9L, 1L, 8L,
                    102L, 66L, 20L, null, 37L,
                    "https://www.kitzski.at/de/bergurlaub-tirol/webcams.html",
                    "https://www.kitzski.at/",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 59.5D, 44D, 29.5D,
                    LocalDate.of(2022, Month.OCTOBER, 29), LocalDate.of(2023, Month.APRIL, 16),
                    LocalTime.of(8, 30), LocalTime.of(16, 0),
                    "The openening times are provided by the ski resort KitzSki – Kitzbühel/\u200BKirchberg and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort KitzSki – Kitzbühel/\u200BKirchberg is located in Kitzbühel (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbühel (District)) and in the Brixental (Austria, Tyrol (Tirol), Tiroler Unterland, Kitzbüheler Alpen). For skiing and snowboarding, there are 188 km of slopes and 45 km of ski routes available. 57 lifts transport the guests. The winter sports area is situated between the elevations of 800 and 2,000 m.",
                    Boolean.TRUE);

            Skiresort wengen = new Skiresort("Grindelwald/Wengen", null, null, 796L, 2400L,
                    0L, 1L, 2L, 10L, 3L, 5L, 3L,
                    33L, 56L, 13L, null, 8L,
                    "https://www.jungfrau.ch/de-ch/live/webcams/#webcam-grindelwald-first",
                    "https://www.jungfrau.ch/de-ch/jungfrau-ski-region/grindelwald-wengen/",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 66D, null, 31D,
                    LocalDate.of(2022, Month.DECEMBER, 10), LocalDate.of(2023, Month.APRIL, 9),
                    LocalTime.of(8, 0), LocalTime.of(16, 30),
                    "The openening times are provided by the ski resort Kleine Scheidegg/\u200BMännlichen – Grindelwald/\u200BWengen and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Kleine Scheidegg/\u200BMännlichen – Grindelwald/\u200BWengen is located in the Jungfrau Region (Switzerland, Espace Mittelland, Bern, Bernese Oberland). For skiing and snowboarding, there are 102 km of slopes available. 24 lifts transport the guests. The winter sports area is situated between the elevations of 944 and 2,400 m.",
                    Boolean.TRUE);

            Skiresort ischgl = new Skiresort("Ischgl", null, null, 1360L, 2872L,
                    0L, 3L, 4L, 25L, 9L, 0L, 0L,
                    47L, 143L, 49L, null, 6L,
                    "https://www.ischgl.com/de/More/Webcams",
                    "https://www.ischgl.com/de/More/Seilbahnunternehmen",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 63D, null, 39D,
                    LocalDate.of(2022, Month.NOVEMBER, 24), LocalDate.of(2023, Month.MAY, 1),
                    LocalTime.of(8, 30), LocalTime.of(16, 00),
                    "The openening times are provided by the ski resort Ischgl/\u200BSamnaun – Silvretta Arena and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Ischgl/\u200BSamnaun – Silvretta Arena is located in Paznaun-Ischgl (Austria, Tyrol (Tirol), Tiroler Oberland, Landeck) and in the Engadin Samnaun Val Müstair Holiday Region (Switzerland, Eastern Switzerland, Graubünden). For skiing and snowboarding, there are 239 km of slopes and 15 km of ski routes available. 41 lifts transport the guests. The winter sports area is situated between the elevations of 1,360 and 2,872 m.",
                    Boolean.TRUE);

            repository.saveAll(
                    List.of(kitzski, wengen, ischgl)
            );
        };
    }

}
