package com.horkovcode.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 13.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@FeignClient(name = "notification", url = "${clients.notification.url}")
public interface NotificationClient {

    @PostMapping("api/v1/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
