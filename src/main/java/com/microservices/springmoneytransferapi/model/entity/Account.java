package com.microservices.springmoneytransferapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;

    private BigDecimal initialBalance;

    public Account() {
    }

    public Account(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

}
