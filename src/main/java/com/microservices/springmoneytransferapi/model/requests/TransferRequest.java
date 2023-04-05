package com.microservices.springmoneytransferapi.model.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransferRequest {
    @NotNull(message = "Source account ID cannot be null")
    private Long sourceAccountId;

    @NotNull(message = "Target account ID cannot be null")
    private Long targetAccountId;

    @NotNull(message = "Transfer amount cannot be null")
    @Min(value = 1, message = "Transfer amount must be greater than zero")
    private BigDecimal amount;

    public void Transfer() {
    }

    public void Transfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }
}
