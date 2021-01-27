package com.booking.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookingRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(Booking.builder().passengerName("burglar").build()));
            log.info("Preloading " + repository.save(Booking.builder().passengerName("thief").build()));
        };
    }
}
