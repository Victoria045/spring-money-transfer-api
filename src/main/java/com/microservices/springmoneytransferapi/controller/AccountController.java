package com.microservices.springmoneytransferapi.controller;

import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.model.requests.TransferRequest;
import com.microservices.springmoneytransferapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService starterService;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Account> createAccount(@RequestBody @Valid Account account) {
        starterService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccountById(@PathVariable final Long id) {
        return starterService.getAccountById(id);
    }

    @PostMapping("/transfers")
    public TransferRequest transferMoney(@RequestBody @Valid TransferRequest transferRequest) throws AccountNotFoundException {
        TransferRequest transfer = starterService.transferMoney(transferRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(transfer).getBody();
    }
}
