package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.InvalidCustomerException;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void shouldCreateCustomer() {
        String name = "John Doe";
        Email email = new Email("john@doe.com");
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);
        var customer = new Customer(name, email, phone, document);

        assertNotNull(customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getDocument());
        assertEquals("12345678901", customer.getDocument().value());
        assertEquals(DocumentType.CPF, customer.getDocument().type());
    }

    @Test
    void shouldCreateExistingCustomerWithId() {
        var id = CustomerId.from(UUID.randomUUID());
        String name = "Jane Doe";
        Email email = new Email("john@doe.com");
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
        assertThrows(InvalidCustomerException.class, () -> new Customer("", new Email("john@doe.com"),
                "+1234567890", null));
        assertThrows(InvalidCustomerException.class, () -> new Customer(null, new Email("john@doe.com"),
                "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", null,
                "+1234567890", null));
        assertThrows(InvalidCustomerException.class, () -> new Customer("John Doe", null,
                "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () ->
                new Customer("John Doe", new Email("john@doe.com"), "", null));
        assertThrows(InvalidCustomerException.class, () ->
                new Customer("John Doe", new Email("john@doe.com"), null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidCustomerException.class, () ->
                new Customer("John Doe", new Email("john@doe.com"), "+1234567890", null));
    }
}