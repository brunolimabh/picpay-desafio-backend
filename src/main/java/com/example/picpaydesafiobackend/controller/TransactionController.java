package com.example.picpaydesafiobackend.controller;

import com.example.picpaydesafiobackend.domain.transaction.Transaction;
import com.example.picpaydesafiobackend.dto.transaction.TransactionDto;
import com.example.picpaydesafiobackend.dto.transaction.TransactionMapper;
import com.example.picpaydesafiobackend.dto.transaction.TransactionResponseDto;
import com.example.picpaydesafiobackend.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    public ResponseEntity<TransactionResponseDto> create(@RequestBody TransactionDto request) throws Exception {
        Transaction entity = this.service.create(request);
        return ResponseEntity.created(null).body(TransactionMapper.toDto(entity));
    }
}
