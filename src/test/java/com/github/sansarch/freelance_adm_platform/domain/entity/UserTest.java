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
   void shouldThrowExceptionWhenIdIsNull() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().id(null).build());
   }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().name(null).build());
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().phone(null).build());
        assertThrows(InvalidUserDataException.class, () -> User.builder().phone("   ").build());
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsNull() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().password(null).build());
        assertThrows(InvalidUserDataException.class, () -> User.builder().password("").build());
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().document(null).build());
    }

    @Test
    void shouldThrowExceptionWhenAccountsAreNull() {
        assertThrows(InvalidUserDataException.class, () -> User.builder().accounts(null).build());
    }
}