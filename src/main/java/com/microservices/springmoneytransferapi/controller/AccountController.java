package com.microservices.springmoneytransferapi.controller;

import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService starterService;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return starterService.createAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccountById(@PathVariable final Long id) {
        return starterService.getAccountById(id);
    }
}
