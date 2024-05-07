package com.example.picpaydesafiobackend.dto.transaction;

import com.example.picpaydesafiobackend.dto.user.UserResponseDto;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponseDto {

    private Long id;
    private BigDecimal ammount;
    private UserResponseDto sender;
    private UserResponseDto receiver;
    private LocalDateTime timestamp;

}
