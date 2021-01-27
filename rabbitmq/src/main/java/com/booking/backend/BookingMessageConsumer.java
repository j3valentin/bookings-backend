package com.booking.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class BookingMessageConsumer {
//    private static final Logger log = LoggerFactory.getLogger(BookingMessageConsumer.class);
//
//    private final BookingRepository bookingRepository;
//
//    @Autowired
//    public BookingMessageConsumer(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//
//    @RabbitListener(queues = MessagingConfig.BOOKING_ADD)
//    public void addBooking(Booking booking) {
//        log.info("Message received from addBooking " + booking);
//    }

    //@RabbitListener(queues = MessagingConfig.BOOKING_EDIT)
    //public void editBooking(Booking booking) {
    //    log.info("Message received from editBooking " + booking);
    //}
    //
    //@RabbitListener(queues = MessagingConfig.BOOKING_DELETE)
    //public void deleteBooking(Booking booking) {
    //    log.info("Message received from deleteBooking " + booking);
    //}
}
