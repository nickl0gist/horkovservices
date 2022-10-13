package com.horkovcode.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 12.10.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
