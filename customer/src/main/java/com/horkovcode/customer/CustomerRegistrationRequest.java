package com.horkovcode.customer;

import lombok.Data;

/**
 * Created on 12.10.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
