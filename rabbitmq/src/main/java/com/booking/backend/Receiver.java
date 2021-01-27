package com.booking.backend;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(Booking booking) {
        System.out.println("Received <" + booking + ">");
    }

}