package com.example.picpaydesafiobackend.controller;

import com.example.picpaydesafiobackend.domain.transaction.Transaction;
import com.example.picpaydesafiobackend.domain.user.User;
import com.example.picpaydesafiobackend.dto.TransactionDto;
import com.example.picpaydesafiobackend.dto.user.UserMapper;
import com.example.picpaydesafiobackend.dto.user.UserRequestDto;
import com.example.picpaydesafiobackend.dto.user.UserResponseDto;
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
    public ResponseEntity<Transaction> create(@RequestBody TransactionDto request) throws Exception {
        Transaction entity = this.service.create(request);
        return ResponseEntity.created(null).body(entity);
    }
}
