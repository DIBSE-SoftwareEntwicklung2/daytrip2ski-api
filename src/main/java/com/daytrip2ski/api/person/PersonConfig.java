package com.daytrip2ski.api.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner insertPersons(PersonRepository repository) {
        return args -> {
            Person martin = new Person("Martin",
                                "Angermair",
                                "martin.angermair@daytrip2ski.com",
                                LocalDate.of(1965, Month.SEPTEMBER, 6));

            Person max = new Person("Max",
                            "Mustermann",
                            "max.mustermann@daytrip2ski.com",
                            LocalDate.of(2000, Month.APRIL, 1));

            repository.saveAll(
                    List.of(martin, max)
            );
        };
    }
}
