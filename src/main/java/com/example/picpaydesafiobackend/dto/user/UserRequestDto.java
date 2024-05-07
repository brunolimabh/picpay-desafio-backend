package com.example.picpaydesafiobackend.dto.user;

import com.example.picpaydesafiobackend.domain.user.UserType;
import lombok.Data;

@Data
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String password;
    private UserType userType;
}
