package com.microservices.springmoneytransferapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Account ID cannot be null")
    private Long id;

    @NotNull(message = "Transfer amount cannot be null")
    @Min(value = 1, message = "Balance amount must be greater than zero")
    private BigDecimal initialBalance;

    public Account() {
    }

    public Account(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

}
