package com.microservices.springmoneytransferapi.service.impl;
import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.repository.AccountRepository;
import com.microservices.springmoneytransferapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }


}
