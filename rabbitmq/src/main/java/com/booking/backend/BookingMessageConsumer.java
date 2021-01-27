package com.booking.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMessageConsumer {
    private static final Logger log = LoggerFactory.getLogger(BookingMessageConsumer.class);

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingMessageConsumer(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RabbitListener(queues = MessagingConfig.BOOKING_ADD)
    public void addBooking(Booking booking) {
        log.info("Message received from addBooking " + booking);
        bookingRepository.save(booking);
    }

    @RabbitListener(queues = MessagingConfig.BOOKING_EDIT)
    public void editBooking(Booking newBooking) {
        log.info("Message received from editBooking " + newBooking);
        bookingRepository.findById(newBooking.getId())
                .map(employee -> {
                    employee.setPassengerName(newBooking.getPassengerName());
                    employee.setPassengerContactNumber(newBooking.getPassengerContactNumber());
                    return bookingRepository.save(employee);
                })
                .orElseGet(() -> {
                    return bookingRepository.save(newBooking);
                });
    }

    @RabbitListener(queues = MessagingConfig.BOOKING_DELETE)
    public void deleteBooking(Long id) {
        log.info("Message received from deleteBooking with id: " + id);
        bookingRepository.deleteById(id);
    }
}
