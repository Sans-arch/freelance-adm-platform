package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.CustomerId;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidCustomerException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private final String VALID_CPF = "12345678901";

    @Test
    void shouldCreateNewCustomer() {
        String name = "John Doe";
        String email = "john@john.com";
        String phone = "1234567890";
        Document document = new Document(VALID_CPF, DocumentType.CPF);
        Customer customer = new Customer(name, email, phone, document);

        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getId());
        assertNotNull(customer.getDocument());
    }

    @Test
    void shouldCreateExistingCustomer() {
        UUID id = UUID.randomUUID();
        CustomerId existingId = CustomerId.from(id);
        String name = "John Doe";
        String email = "john@john.com";
        String phone = "1234567890";
        Document document = new Document(VALID_CPF, DocumentType.CPF);
        Customer customer = new Customer(existingId, name, email, phone, document);

        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertNotNull(customer.getId());
        assertEquals(id, customer.getId().getValue());
        assertEquals(existingId.getValue(), customer.getId().getValue());
        assertNotNull(customer.getDocument());
    }

    @Test
    void shouldNotCreateCustomerWithNullValues() {
       assertThrows(InvalidCustomerException.class, () -> {
           new Customer(null, null, null, null);
       });
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("John Doe", null, "1234567890", null);
        });

        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("John Doe", "", "1234567890", null);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> {
            new Customer(null, null, "1234567890", null);
        });

        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("", null, "1234567890", null);
        });
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("John Doe", "joh@doe.com", null, null);
        });

        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("John Doe", "john@doe.com", "", null);
        });
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidCustomerException.class, () -> {
            new Customer("John Doe", "john@doe.com", "+419982832", null);
        });
    }
}