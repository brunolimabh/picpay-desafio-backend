package com.example.picpaydesafiobackend.service;

import com.example.picpaydesafiobackend.domain.user.User;
import com.example.picpaydesafiobackend.domain.user.UserType;
import com.example.picpaydesafiobackend.dto.user.UserMapper;
import com.example.picpaydesafiobackend.dto.user.UserRequestDto;
import com.example.picpaydesafiobackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void validadeTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario lojista não está autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }

    }

    public User create(UserRequestDto request) {
        return this.save(UserMapper.toEntity(request));
    }

    public List<User> listAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow( () -> new Exception("Usuario não encontrado"));
    }

    public User save(User user) {
        return this.repository.save(user);
    }
}
