package com.microservices.springmoneytransferapi.service.impl;
import com.microservices.springmoneytransferapi.exceptions.InsufficientFundsException;
import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.model.requests.TransferRequest;
import com.microservices.springmoneytransferapi.repository.AccountRepository;
import com.microservices.springmoneytransferapi.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        BigDecimal amount = account.getInitialBalance();
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new InsufficientFundsException.AccountBalanceNegativeException("Account balance can't be zero.", HttpStatus.BAD_REQUEST);
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException.AccountBalanceNegativeException("Account balance can't be negative.", HttpStatus.BAD_REQUEST);
        }
        return accountRepository.save(account);
    }
    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    @Transactional
    public TransferRequest transferMoney(TransferRequest transferRequest) throws AccountNotFoundException {
        Long sourceAccountId = transferRequest.getSourceAccountId();
        Long targetAccountId = transferRequest.getTargetAccountId();
        BigDecimal amount = transferRequest.getAmount();

        Account sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new AccountNotFoundException());
        Account targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new AccountNotFoundException());

        if (sourceAccount.getInitialBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException();
        }
        sourceAccount.setInitialBalance(sourceAccount.getInitialBalance().subtract(amount));
        accountRepository.save(sourceAccount);

        targetAccount.setInitialBalance(targetAccount.getInitialBalance().add(amount));
        accountRepository.save(targetAccount);

        return transferRequest;
    }
}
