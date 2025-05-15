package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidUserDataException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateNewUser() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);
        List<AccountType> accounts = Arrays.asList(AccountType.CUSTOMER);
        AccountType mainAccount = AccountType.CUSTOMER;

        var user = new User(name, email, phone, document, accounts, mainAccount);

        assertNotNull(user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(phone, user.getPhone());
        assertNotNull(user.getDocument());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () ->
                new User("", null, null, null, null, null));

        assertThrows(InvalidUserDataException.class, () ->
                new User(null, null, null, null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () ->
                new User("John Doe", "", "+1234567890", null, null, null));
        assertThrows(InvalidUserDataException.class, () ->
                new User("John Doe", null, "+1234567890", null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () ->
                new User("John Doe", "john@doe.com", "", null, null, null));
        assertThrows(InvalidUserDataException.class, () ->
                new User("John Doe", "john@doe.com", null, null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidUserDataException.class, () ->
                new User("John Doe", "john@doe.com", "+1234567890", null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenAccountsAreNull() {
        assertThrows(InvalidUserDataException.class, () -> {
            var document = new Document("12345678901", DocumentType.CPF);
            new User("John Doe", "", "+1234567890", document, null, null);
        });
    }
}