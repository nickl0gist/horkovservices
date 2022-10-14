package com.horkovcode.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created on 14.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
public class ApiGWApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiGWApp.class, args);
    }
}
