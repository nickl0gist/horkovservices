package com.horkovcode.notification;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 13.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
