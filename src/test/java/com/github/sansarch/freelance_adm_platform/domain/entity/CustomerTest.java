package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.CustomerId;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidCustomerException;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidFreelancerException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void shouldCreateCustomer() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var customer = new Customer(name, email, phone, document);

        assertNotNull(customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getDocument());
        assertEquals("12345678901", customer.getDocument().getValue());
        assertEquals(DocumentType.CPF, customer.getDocument().getType());
    }

    @Test
    void shouldCreateExistingCustomerWithId() {
        var id = CustomerId.from(UUID.randomUUID());
        String name = "Jane Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var customer = new Customer(id, name, email, phone, document);

        assertEquals(id, customer.getId());
        assertEquals(id.getValue(), customer.getId().getValue());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> new Customer("", "john@doe.com", "+1234567890", null));
        assertThrows(InvalidCustomerException.class, () -> new Customer(null, "john@doe.com", "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", "", "+1234567890", null));
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", null, "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", "john@doe.com", "", null));
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", "john@doe.com", null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", "john@doe.com", "+1234567890", null));
    }
}