package com.microservices.springmoneytransferapi.service.impl;
import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.repository.AccountRepository;
import com.microservices.springmoneytransferapi.service.StarterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StarterServiceImpl implements StarterService {
    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

}
