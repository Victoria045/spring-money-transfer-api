package com.microservices.springmoneytransferapi.model.requests;

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
    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;
}
