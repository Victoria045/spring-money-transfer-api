package com.microservices.springmoneytransferapi.service;

import com.microservices.springmoneytransferapi.model.entity.Account;

import java.math.BigDecimal;

public interface StarterService {
    Account createAccount(Account account);
}