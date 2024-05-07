package com.example.picpaydesafiobackend.controller;

import com.example.picpaydesafiobackend.domain.user.User;
import com.example.picpaydesafiobackend.dto.user.UserMapper;
import com.example.picpaydesafiobackend.dto.user.UserRequestDto;
import com.example.picpaydesafiobackend.dto.user.UserResponseDto;
import com.example.picpaydesafiobackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto request) {
        User user = this.service.create(request);
        return ResponseEntity.created(null).body(UserMapper.toDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listAll() {
        List<User> users = this.service.listAll();
        if (users.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(UserMapper.toDto(users));
    }

}
