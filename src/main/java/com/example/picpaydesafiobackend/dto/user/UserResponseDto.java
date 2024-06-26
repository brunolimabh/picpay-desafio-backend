package com.example.picpaydesafiobackend.dto.user;

import com.example.picpaydesafiobackend.domain.user.UserType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private BigDecimal balance;
    private UserType userType;

}
