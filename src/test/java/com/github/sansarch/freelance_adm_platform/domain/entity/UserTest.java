package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.UserFactory;
import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidUserDataException;
import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Email;
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
        String password = "securePassword";
        Document document = new Document("12345678901", DocumentType.CPF);
        List<AccountType> accounts = Arrays.asList(AccountType.CUSTOMER);
        AccountType mainAccount = AccountType.CUSTOMER;

        var user = UserFactory.createUser(name, email, phone, password, document, accounts, mainAccount);

        assertNotNull(user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(phone, user.getPhone());
        assertNotNull(user.getDocument());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(InvalidUserDataException.class, () ->
                new User(null, null, null, null, null, null,
                        null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () ->
                new User(UserId.generate(), "John Doe", null, "+1234567890", "",
                        null, null, null));
        assertThrows(InvalidUserDataException.class, () ->
                new User(UserId.generate(), "John Doe", null, "+1234567890", "",
                        null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () ->
                new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "",
                        "", null, null, null));
        assertThrows(InvalidUserDataException.class, () ->
                new User(UserId.generate(), "John Doe", null, null, null,
                        null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidUserDataException.class, () ->
                new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "+1234567890",
                        "", null, null, null));
    }

    @Test
    void shouldThrowExceptionWhenAccountsAreNull() {
        assertThrows(InvalidUserDataException.class, () -> {
            var document = new Document("12345678901", DocumentType.CPF);
            new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "+1234567890",
                    "", document, null, null);
        });
    }
}