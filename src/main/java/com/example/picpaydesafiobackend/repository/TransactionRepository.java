package com.example.picpaydesafiobackend.repository;

import com.example.picpaydesafiobackend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
