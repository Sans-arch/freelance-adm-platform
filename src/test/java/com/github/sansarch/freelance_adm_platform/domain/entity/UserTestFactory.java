package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;

import java.util.Set;

public abstract class UserTestFactory {

    public static User generateValidUser() {
        return User.builder()
                .id(UserId.generate())
                .name("John")
                .email("john@doe.com")
                .phone("+41884772232")
                .password("123456")
                .document(new Document("826.453.653-02", DocumentType.CPF))
                .accounts(Set.of(AccountType.CUSTOMER))
                .build();
    }
}
