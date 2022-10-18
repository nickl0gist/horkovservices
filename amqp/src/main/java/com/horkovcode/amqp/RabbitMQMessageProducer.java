package com.horkovcode.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * Created on 18.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> the class that allows to publish to an Exchange by passing the exchangeName, routingKey and the Object.
 */
@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        log.info("BEFORE: Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("AFTER: Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
    }
}
