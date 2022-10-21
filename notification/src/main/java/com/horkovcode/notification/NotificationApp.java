package com.horkovcode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created on 13.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.horkovcode.notification",
                "com.horkovcode.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.horkovcode.clients"

)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }

    /**
     * Uncomment this in order to test Messaging right after starting Notification App.
    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
            return args -> {
                producer.publish(
                        new Person("Jumanji", 27),
                        notificationConfig.getInternalExchange(),
                        notificationConfig.getInternalNotificationRoutingKey()
                );
            };
    }

    @Data
    @AllArgsConstructor
    class Person{
        private String name;
        private int age;
    } */
}
