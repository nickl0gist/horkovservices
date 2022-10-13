package com.horkovcode.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 13.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;
}
