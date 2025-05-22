package com.github.sansarch.freelance_adm_platform.application.usecase.user;

import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;

import java.util.List;

public class UserFactory {

    public static User createUser(String name, String email, String phone, Document document, List<AccountType> accounts, AccountType mainAccount) {
        return new User(UserId.generate(), name, email, phone, document, accounts, mainAccount);
    }

    public static User restoreUser(UserId id, String name, String email, String phone, Document document, List<AccountType> accounts, AccountType mainAccount) {
        return new User(id, name, email, phone, document, accounts, mainAccount);
    }
}
