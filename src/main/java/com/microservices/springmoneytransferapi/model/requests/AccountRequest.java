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
public class AccountRequest {
    private int id;
    private String initialBalance;
}
