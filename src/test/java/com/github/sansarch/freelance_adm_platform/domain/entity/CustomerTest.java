package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.CustomerId;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidCustomerException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateNewCustomer() {
        String name = "John Doe";
        String email = "john@john.com";
        String phone = "1234567890";
        Customer customer = new Customer(name, email, phone);

        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getId());
    }

    @Test
    void shouldCreateExistingCustomer() {
        UUID id = UUID.randomUUID();
        CustomerId existingId = new CustomerId(id);
        String name = "John Doe";
        String email = "john@john.com";
        String phone = "1234567890";
        Customer customer = new Customer(existingId, name, email, phone);

        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getId());
        assertEquals(id, customer.getId().getValue());
        assertEquals(existingId.getValue(), customer.getId().getValue());
    }

    @Test
    void shouldNotCreateCustomerWithNullValues() {
       assertThrows(InvalidCustomerException.class, () -> {
           new Customer(null, null, null);
       });
    }
}