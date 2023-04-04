package com.microservices.springmoneytransferapi.controller;

import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.service.StarterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    private final StarterService starterService;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return starterService.createAccount(account);
    }
}
