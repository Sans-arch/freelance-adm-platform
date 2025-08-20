package com.github.sansarch.freelance_adm_platform.customer.domain.exception;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String message) {
        super(message);
    }
}
