package com.horkovcode.customer;

import com.horkovcode.amqp.RabbitMQMessageProducer;
import com.horkovcode.clients.fraud.FraudCheckResponse;
import com.horkovcode.clients.fraud.FraudClient;
import com.horkovcode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created on 12.10.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    //private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);

        // Before Feign was used
        /**FraudCheckResponse response = restTemplate.getForObject(
                //without EUREKA
                //"http://localhost:8081/api/v1/fraud-check/{customerId}",

                // with EUREKA
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );*/

        // With usage of Feign
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.getFraudster()) {
            throw new IllegalStateException("fraudster wtf");
        }



        NotificationRequest notificationRequest = NotificationRequest.builder()
                .toCustomerEmail(customer.getEmail())
                .toCustomerId(customer.getId())
                .message(String.format("Customer with email: %s has been created with id: %d", customer.getEmail(), customer.getId()))
                .build();
        /**
         * This approach used before RabbitMQ implementation
        notificationClient.sendNotification(notificationRequest);
         */

        // With RabbitMQ achieved async message notification
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchnge",
                "internal.notification.routing-key");
    }
}
