package com.horkovcode.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 12.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
