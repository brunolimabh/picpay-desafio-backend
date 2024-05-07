package com.example.picpaydesafiobackend.domain.transaction;

import com.example.picpaydesafiobackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal ammount;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    private LocalDateTime timestamp;

}
