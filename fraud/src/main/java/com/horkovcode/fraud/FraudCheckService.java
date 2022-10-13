package com.horkovcode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/**
 * Created on 12.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
              FraudCheckHistory.builder()
                      .customerId(customerId)
                      .isFraudster(false)
                      .createdAt(LocalDateTime.now())
                      .build()
        );
        return false;
    }
}
