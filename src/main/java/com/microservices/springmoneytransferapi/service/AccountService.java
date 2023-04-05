package com.microservices.springmoneytransferapi.service;

import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.model.requests.TransferRequest;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);

    Optional<Account> getAccountById(Long id);

    TransferRequest transferMoney(TransferRequest transferRequest) throws AccountNotFoundException;

}