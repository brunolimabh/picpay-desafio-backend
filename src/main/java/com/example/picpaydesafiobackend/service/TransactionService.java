package com.example.picpaydesafiobackend.service;

import com.example.picpaydesafiobackend.domain.transaction.Transaction;
import com.example.picpaydesafiobackend.domain.user.User;
import com.example.picpaydesafiobackend.dto.TransactionDto;
import com.example.picpaydesafiobackend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final UserService userService;
    private final RestTemplate restTemplate;

    public void createTransaction(TransactionDto transaction) throws Exception {
        User sender = this.userService.findById(transaction.senderId());
        User receiver = this.userService.findById(transaction.receiverId());

        this.userService.validadeTransaction(sender, transaction.value());

        boolean isAuthorized =this.authorizeTransaction(sender, transaction.value());
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.save(sender);
        this.userService.save(receiver);



    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return message.equalsIgnoreCase("Autorizado");
        }
        return false;
    }
}
