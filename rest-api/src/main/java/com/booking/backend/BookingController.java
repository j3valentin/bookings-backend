package com.booking.backend;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    List<Booking> all() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Booking> one(@PathVariable Long id) {
        return bookingRepository.findById(id);
    }

    @PostMapping
    String addBooking(@RequestBody Booking booking) {
        rabbitTemplate.convertAndSend(MessagingConfig.MESSAGE_EXCHANGE, MessagingConfig.BOOKING_ADD, booking);
        return "Success!!!";
    }

    @PutMapping("/{id}")
    String replaceBooking(@RequestBody Booking newBooking, @PathVariable Long id) {
        rabbitTemplate.convertAndSend(MessagingConfig.MESSAGE_EXCHANGE, MessagingConfig.BOOKING_EDIT, newBooking);
        return "Success!!!";
    }

    @DeleteMapping("/{id}")
    String deleteBooking(@PathVariable Long id) {
        rabbitTemplate.convertAndSend(MessagingConfig.MESSAGE_EXCHANGE, MessagingConfig.BOOKING_DELETE, id);
        return "Success!!!";
    }
}
