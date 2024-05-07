package com.example.picpaydesafiobackend.dto.transaction;

import com.example.picpaydesafiobackend.domain.transaction.Transaction;
import com.example.picpaydesafiobackend.dto.user.UserMapper;

public class TransactionMapper {

    public static TransactionResponseDto toDto(Transaction entity) {
        if (entity == null) return null;

        TransactionResponseDto dto = new TransactionResponseDto();
        dto.setId(entity.getId());
        dto.setAmmount(entity.getAmmount());
        dto.setSender(UserMapper.toDto(entity.getSender()));
        dto.setReceiver(UserMapper.toDto(entity.getReceiver()));
        return dto;
    }
}
