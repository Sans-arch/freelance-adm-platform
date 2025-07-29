package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.exception.InvalidUserDataException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateNewUser() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        String password = "securePassword";
        Document document = new Document("12345678901", DocumentType.CPF);
        Set<AccountType> accounts = Set.of(AccountType.CUSTOMER);

        var user = User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .document(document)
                .accounts(accounts)
                .build();

        assertNotNull(user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail().value());
        assertEquals(phone, user.getPhone());
        assertNotNull(user.getDocument());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(InvalidUserDataException.class, () ->
                new User(null, null, null, null, null, null,
                        null));
    }

//    @Test
//    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
//        assertThrows(InvalidUserDataException.class, () ->
//                new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "",
//                        "", null, null, null));
//        assertThrows(InvalidUserDataException.class, () ->
//                new User(UserId.generate(), "John Doe", null, null, null,
//                        null, null, null));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenDocumentIsNull() {
//        assertThrows(InvalidUserDataException.class, () ->
//                new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "+1234567890",
//                        "", null, null, null));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenAccountsAreNull() {
//        assertThrows(InvalidUserDataException.class, () -> {
//            var document = new Document("12345678901", DocumentType.CPF);
//            new User(UserId.generate(), "John Doe", new Email("john@doe.com"), "+1234567890",
//                    "", document, null, null);
//        });
//    }
}