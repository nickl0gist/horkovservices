package com.horkovcode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created on 12.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.horkovcode.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
