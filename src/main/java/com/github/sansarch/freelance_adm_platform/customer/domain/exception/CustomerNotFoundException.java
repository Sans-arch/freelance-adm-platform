package com.github.sansarch.freelance_adm_platform.customer.domain.exception;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(UUID customerId) {
        super("Customer not found: " + customerId);
    }
}
