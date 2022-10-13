package com.horkovcode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created on 13.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.horkovcode.clients"
)
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }
}
