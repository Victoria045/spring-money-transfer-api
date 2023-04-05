package com.microservices.springmoneytransferapi.service.impl;
import com.microservices.springmoneytransferapi.model.entity.Account;
import com.microservices.springmoneytransferapi.model.requests.TransferRequest;
import com.microservices.springmoneytransferapi.repository.AccountRepository;
import com.microservices.springmoneytransferapi.service.AccountService;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

        return accountRepository.save(account);
    }

//    public Account findAll(){
//        return (Account) accountRepository.findAll();
//    }
    @Override
    public Account findAll(Account account) {
        return null;
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

        if (sourceAccount.getInitialBalance().compareTo(BigDecimal.ONE) == 1
                && targetAccount.getInitialBalance().compareTo(amount) == 1
        ){
            sourceAccount.setInitialBalance(sourceAccount.getInitialBalance().subtract(amount));
            accountRepository.save(sourceAccount);

            targetAccount.setInitialBalance(targetAccount.getInitialBalance().add(amount));
            accountRepository.save(targetAccount);
        }
        return transferRequest;
    }

}
