package com.example.picpaydesafiobackend.dto.user;

import com.example.picpaydesafiobackend.domain.user.UserType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String password;
    private BigDecimal balance;
    private UserType userType;
}
