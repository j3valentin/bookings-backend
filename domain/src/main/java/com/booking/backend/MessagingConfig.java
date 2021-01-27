package com.booking.backend;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String MESSAGE_AUDIT_QUEUE = "MessageAuditQueue";
    public static final String MESSAGE_EXCHANGE = "MessageExchange";

    public static final String BOOKING_EXCHANGE = "BookingExchange";

    public static final String BOOKING_ADD_QUEUE = "BookingAddQueue";
    public static final String BOOKING_ADD = "BookingAdd";

    public static final String BOOKING_EDIT_QUEUE = "BookingEditQueue";
    public static final String BOOKING_EDIT = "BookingEdit";

    public static final String BOOKING_DELETE_QUEUE = "BookingDeleteQueue";
    public static final String BOOKING_DELETE = "BookingDelete";
/*
    @Bean
    public Queue messageAuditQueue() { return new Queue(MESSAGE_AUDIT_QUEUE); }

    @Bean
    public FanoutExchange messageExchange() { return new FanoutExchange(MESSAGE_EXCHANGE); }

    @Bean
    public Binding message(Queue messageAuditQueue, FanoutExchange messageExchange) {
        return BindingBuilder.bind(messageAuditQueue).to(messageExchange);
    }

    @Bean
    public DirectExchange bookingExchange() { return new DirectExchange(BOOKING_EXCHANGE); }

    @Bean
    public Binding booking(DirectExchange bookingExchange, FanoutExchange messageExchange) {
        return BindingBuilder.bind(bookingExchange).to(messageExchange);
    }

    @Bean
    public Queue bookingAddQueue() { return new Queue(BOOKING_ADD_QUEUE); }

    @Bean
    public Binding bookingAdd(Queue bookingAddQueue, DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingAddQueue).to(bookingExchange).with(BOOKING_ADD);
    }

    @Bean
    public Queue bookingEditQueue() { return new Queue(BOOKING_EDIT_QUEUE); }

    @Bean
    public Binding bookingEdit(Queue bookingEditQueue, DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingEditQueue).to(bookingExchange).with(BOOKING_EDIT);
    }

    @Bean
    public Queue bookingDeleteQueue() { return new Queue(BOOKING_DELETE_QUEUE); }

    @Bean
    public Binding bookingDelete(Queue bookingDeleteQueue, DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingDeleteQueue).to(bookingExchange).with(BOOKING_DELETE);
    }

    //@Bean
    //public MessageConverter converter() {
    //    return new Jackson2JsonMessageConverter();
    //}

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }*/
}
