package com.microservices.springmoneytransferapi.service;

import com.microservices.springmoneytransferapi.model.entity.Account;

import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);

    Optional<Account> getAccountById(Long id);

}