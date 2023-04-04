package com.microservices.springmoneytransferapi.repository;

import com.microservices.springmoneytransferapi.model.entity.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository <Account, String> {
}