package com.example.picpaydesafiobackend.dto.transaction;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, Long senderId, Long receiverId) {
}
