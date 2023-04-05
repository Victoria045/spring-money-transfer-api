package com.microservices.springmoneytransferapi.exceptions;

import org.springframework.http.HttpStatus;


public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("The source account does not have sufficient funds for the transfer");
    }

    public static class AccountBalanceNegativeException extends RuntimeException {

        private final HttpStatus status;
        public AccountBalanceNegativeException(String message, HttpStatus status) {

            super(message);
            this.status = status;
        }
        public HttpStatus getStatus() {
            return status;
        }
    }
}
