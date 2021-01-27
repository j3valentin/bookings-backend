package com.booking.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.booking.backend")
public class BackendRabbitmqApplication {

	public static void main(String[] args) { SpringApplication.run(BackendRabbitmqApplication.class, args); }

}
