package com.microservices.springmoneytransferapi.repository;

import com.microservices.springmoneytransferapi.model.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}