package com.daytrip2ski.api.skiresort;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class SkiresortConfig {

    /**
     * Inserts demo data for development
     * @param repository of Skiresorts
     * @return
     */
    @Bean
    CommandLineRunner insertSkiresorts(SkiresortRepository repository) {
        return args -> {
            Skiresort kitzski = new Skiresort("KitzSki", 47.444990D, 12.391430D, 800L, 2000L,
                    0L, 0L, 1L, 22L, 27L, 9L, 1L, 8L,
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

            Skiresort wengen = new Skiresort("Grindelwald/Wengen", 46.6765034325D, 7.86640045D, 796L, 2400L,
                    0L, 0L, 1L, 2L, 10L, 3L, 5L, 3L,
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

            Skiresort ischgl = new Skiresort("Ischgl", 47.011845, 10.288420, 1360L, 2872L,
                    0L, 0L, 3L, 4L, 25L, 9L, 0L, 0L,
                    47L, 143L, 49L, null, 6L,
                    "https://www.ischgl.com/de/More/Webcams",
                    "https://www.ischgl.com/de/More/Seilbahnunternehmen",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 63D, null, 39D,
                    LocalDate.of(2022, Month.NOVEMBER, 24), LocalDate.of(2023, Month.MAY, 1),
                    LocalTime.of(8, 30), LocalTime.of(16, 0),
                    "The openening times are provided by the ski resort Ischgl/\u200BSamnaun – Silvretta Arena and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Ischgl/\u200BSamnaun – Silvretta Arena is located in Paznaun-Ischgl (Austria, Tyrol (Tirol), Tiroler Oberland, Landeck) and in the Engadin Samnaun Val Müstair Holiday Region (Switzerland, Eastern Switzerland, Graubünden). For skiing and snowboarding, there are 239 km of slopes and 15 km of ski routes available. 41 lifts transport the guests. The winter sports area is situated between the elevations of 1,360 and 2,872 m.",
                    Boolean.TRUE);

            Skiresort groeden = new Skiresort("Val Gardena (Gröden)", 46.559758D, 11.704926D, 1236L, 2518L,
                    0L, 2L, 2L, 9L, 41L, 23L, 1L, 0L,
                    52L, 105L, 21L, null, 9L,
                    "https://sts104.feratel.co.at/streams/stsstore103/1/06345_62a96fa5-a71bVid.mp4?dcsdesign=feratel4",
                    "https://www.valgardena.it/de/",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 62D, 43D, 43D,
                    LocalDate.of(2022, Month.DECEMBER, 3), LocalDate.of(2023, Month.APRIL, 11),
                    LocalTime.of(8, 30), LocalTime.of(16, 30),
                    "The openening times are provided by the ski resort Val Gardena (Gröden) and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Val Gardena (Gröden) is located in Val Gardena (Gröden) (Italy, Trentino-Alto Adige (Trentino-Südtirol), South Tyrol (Südtirol)). For skiing and snowboarding, there are 178 km of slopes available. 79 lifts transport the guests. The winter sports area is situated between the elevations of 1,236 and 2,518 m.",
                    Boolean.TRUE);

            Skiresort schladming = new Skiresort("Schladming – Planai", 47.394203D, 13.685440D, 728L, 2015L,
                    0L, 1L, 1L, 9L, 20L, 12L, 0L, 3L,
                    46L, 68L, 8L, null, 4L,
                    "https://sts103.feratel.co.at/streams/stsstore104/1/05420_62a9721a-f976Vid.mp4?dcsdesign=feratel4",
                    "https://www.planai.at/de",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 60.5D, 45.5D, 30.5D,
                    LocalDate.of(2022, Month.NOVEMBER, 26), LocalDate.of(2023, Month.APRIL, 17),
                    LocalTime.of(8, 15), LocalTime.of(16, 30),
                    "The openening times are provided by the ski resort Schladming – Planai/\u200B\u200BHochwurzen/\u200B\u200BHauser Kaibling/\u200B\u200BReiteralm (4-Berge-Skischaukel) and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Val Gardena (Gröden) is located in Val Gardena (Gröden) (Italy, Trentino-Alto Adige (Trentino-Südtirol), South Tyrol (Südtirol)). For skiing and snowboarding, there are 178 km of slopes available. 79 lifts transport the guests. The winter sports area is situated between the elevations of 1,236 and 2,518 m.\",",
                    Boolean.TRUE);

            Skiresort anton = new Skiresort("St. Anton/\u200BLech/\u200BZürs/\u200BWarth/\u200B", 47.129635D, 10.268179D, 1300L, 2811L,
                    0L, 0L, 5L, 11L, 43L, 22L, 4L, 2L,
                    130L, 121L, 51L, null, 12L,
                    "https://www.stantonamarlberg.com/XooWebKit/bin/imagecache.php/source/3_f20030bb0272cc21.20220615075132/c47_QU3j4/20220615074924.jpg?width=588",
                    "https://www.stantonamarlberg.com/de/winter/skigebiet/aktuelles-zum-arlberg-skigebiet",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 61D, 55D, 36.5D,
                    LocalDate.of(2022, Month.NOVEMBER, 26), LocalDate.of(2023, Month.APRIL, 17),
                    LocalTime.of(8, 15), LocalTime.of(16, 30),
                    "The openening times are provided by the ski resort St. Anton/\u200BSt. Christoph/\u200BStuben/\u200BLech/\u200BZürs/\u200BWarth/\u200BSchröcken – Ski Arlberg and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort St. Anton/\u200BSt. Christoph/\u200BStuben/\u200BLech/\u200BZürs/\u200BWarth/\u200BSchröcken – Ski Arlberg is located in St. Anton am Arlberg (Austria, Tyrol (Tirol), Tiroler Oberland, Landeck) and in the Bregenzerwald (Austria, Vorarlberg, Bregenz). For skiing and snowboarding, there are 302 km of slopes and 200 km of ski routes available. 88 lifts transport the guests. The winter sports area is situated between the elevations of 1,300 and 2,811 m.",
                    Boolean.TRUE);

            Skiresort flachau = new Skiresort("Snow Space Salzburg – Flachau", 47.353417D, 13.394444D, 740L, 1980L,
                    0L, 0L, 2L, 10L, 16L, 8L, 7L, 2L,
                    34L, 82L, 4L, null, 9L,
                    "https://wtvthmb.feratel.com/thumbnails/5292.jpeg?t=38&dcsdesign=WTP_skiresort.de&design=v3",
                    "https://www.snow-space.com/en/winter/region/villages/flachau",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 61D, 46D, 30.5D,
                    LocalDate.of(2022, Month.DECEMBER, 16), LocalDate.of(2023, Month.APRIL, 18),
                    LocalTime.of(8, 30), LocalTime.of(16, 15),
                    "The openening times are provided by the ski resort Snow Space Salzburg – Flachau/\u200BWagrain/\u200BSt. Johann-Alpendorf and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Snow Space Salzburg – Flachau/\u200BWagrain/\u200BSt. Johann-Alpendorf is located in the Salzburger Sportwelt (Austria, Salzburg (Salzburger Land), Pongau). For skiing and snowboarding, there are 120.1 km of slopes and 5 km of ski routes available. 45 lifts transport the guests. The winter sports area is situated between the elevations of 740 and 1,980 m.",
                    Boolean.TRUE);

            Skiresort innsbruck = new Skiresort("Skigebiet Patscherkofel – Innsbruck-Igls", 47.231880D, 11.408540D, 1009L, 1965L,
                    0L, 0L, 0L, 1L, 0L, 3L, 1L, 1L,
                    5L, 10L, 4L, null, 3L,
                    "https://portal.live-panorama.com/patscherkofel/bergstation.mp4",
                    "https://www.patscherkofelbahn.at/#sommer",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE , 41D,33.3D, 25.6D,
                    LocalDate.of(2022, Month.DECEMBER, 17), LocalDate.of(2023, Month.APRIL, 2),
                    LocalTime.of(8, 30), LocalTime.of(16, 0),
                    "The openening times are provided by the ski resort Patscherkofel – Innsbruck-Igls and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Patscherkofel – Innsbruck-Igls is located in the Innsbruck region (Austria, Tyrol (Tirol)). For skiing and snowboarding, there are 19 km of slopes available. 6 lifts transport the guests. The winter sports area is situated between the elevations of 1,009 and 1,965 m.\n" +
                            "\n",
                    Boolean.TRUE);

            Skiresort valdisere = new Skiresort("Tignes/\u200BVal d'Isère", 45.468323D, 6.905578D, 1550L, 3456L,
                    0L, 2L, 2L, 7L, 40L, 29L, 2L, 0L,
                    170L, 78L, 52L, null, 16L,
                    "https://www.valdisere.com/en/webcam/webcam-village/",
                    "https://www.valdisere.com/en/ski/ski-area/",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 63D, null, 51D,
                    LocalDate.of(2022, Month.JUNE, 18), LocalDate.of(2022, Month.JULY, 31),
                    LocalTime.of(9, 30), LocalTime.of(16, 30),
                    "The openening times are provided by the ski resort Tignes/\u200BVal d'Isère and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Tignes/\u200BVal d'Isère is located in the Tarentaise (France, Auvergne-Rhône-Alpes, Savoie Mont Blanc, Savoie, Albertville). For skiing and snowboarding, there are 300 km of slopes and 20 km of ski routes available. 82 lifts transport the guests. The winter sports area is situated between the elevations of 1,550 and 3,456 m.",
                    Boolean.TRUE);

            Skiresort kleinkirchheim = new Skiresort("Bad Kleinkirchheim", 46.8144214D, 13.7983599D, 1087L, 2055L,
                    0L, 0L, 0L, 4L, 8L, 9L, 1L, 0L,
                    18L, 77L, 8L, null, 7L,
                    "https://www.valdisere.com/en/webcam/webcam-village/",
                    "https://www.valdisere.com/en/ski/ski-area/",
                    Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 52.5D, 40D, 26.5D,
                    LocalDate.of(2022, Month.DECEMBER, 8), LocalDate.of(2023, Month.APRIL, 2),
                    LocalTime.of(8, 30), LocalTime.of(16, 0),
                    "The openening times are provided by the ski resort Bad Kleinkirchheim and can vary based on external conditions, day of the week, school holidays and public holidays.",
                    null,
                    "The ski resort Bad Kleinkirchheim is located in the District of Spittal an der Drau (Austria, Carinthia (Kärnten), Upper Carinthia (Oberkärnten)). For skiing and snowboarding, there are 103 km of slopes and 5 km of ski routes available. 22 lifts transport the guests. The winter sports area is situated between the elevations of 1,087 and 2,055 m.",
                    Boolean.TRUE);

            repository.saveAll(
                    List.of(kitzski, wengen, ischgl, groeden, schladming, anton, flachau, innsbruck, valdisere, kleinkirchheim)
            );
        };
    }

}
