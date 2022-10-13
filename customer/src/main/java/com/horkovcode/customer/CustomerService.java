package com.horkovcode.customer;

import com.horkovcode.clients.fraud.FraudCheckResponse;
import com.horkovcode.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 12.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);

        // Before Feign was used
        /*FraudCheckResponse response = restTemplate.getForObject(
                //without EUREKA
                //"http://localhost:8081/api/v1/fraud-check/{customerId}",

                // with EUREKA
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );*/

        // With usage of Feign
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.getFraudster()){
            throw new IllegalStateException("fraudster wtf");
        }
    }
}
