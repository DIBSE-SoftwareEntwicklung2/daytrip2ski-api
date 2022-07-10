package com.daytrip2ski.api.skiresort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Testing service of skiresort
 */
class SkiresortServiceTest {
    @InjectMocks
    SkiresortService skiresortService;

    @Mock
    SkiresortRepository skiresortRepository;

    Skiresort skiresort;

    /**
     * Set up before each test
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        skiresortService = new SkiresortService(skiresortRepository);

        skiresort = new Skiresort("KitzSki", 47.444990D, 12.391430D, 800L, 2000L,
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
    }

    /**
     * Get all skiresorts
     */
    @Test
    void getSkiresorts() {
        List<Skiresort> skiresorts = new ArrayList<>();
        skiresorts.add(skiresort);
        when(skiresortRepository.findAll()).thenReturn(skiresorts);
        List<Skiresort> allSkiresorts = skiresortService.getSkiresorts();

        assertEquals(1, allSkiresorts.size());
        assertEquals(skiresort, allSkiresorts.get(0));
    }

    /**
     * Find skiresort by id
     */
    @Test
    void findSkiresortById() {
        Optional<Skiresort> sr = Optional.of(skiresort);
        when(skiresortRepository.findById(1L)).thenReturn(sr);
        Optional<Skiresort> sr1 = skiresortService.findSkiresortById(1L);

        assertEquals(sr, sr1);
    }

    /**
     * Get skiresort not found
     */
    @Test
    void getSkiresortByIdNotFound() {
        Optional<Skiresort> sr = Optional.of(skiresort);
        when(skiresortRepository.findById(1L)).thenReturn(sr);
        Exception ex = assertThrows(IllegalStateException.class, () -> skiresortService.findSkiresortById(2L));

        assertEquals("Skiresort not there", ex.getMessage());
    }
}
