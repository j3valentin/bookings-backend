package com.booking.backend;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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

    static final String topicExchangeName = "spring-boot-exchange";

    static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        return new Queue(BOOKING_ADD_QUEUE, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(BOOKING_EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //container.setQueueNames(BOOKING_ADD_QUEUE, BOOKING_EDIT_QUEUE, BOOKING_DELETE_QUEUE);
        container.setQueueNames(BOOKING_ADD_QUEUE);
        container.setMessageListener(listenerAdapter);
        //listenerAdapter.setMessageConverter(jsonMessageConverter());
        return container;
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
        messageListenerAdapter.setMessageConverter(jsonMessageConverter());
        return messageListenerAdapter;
    }
}
