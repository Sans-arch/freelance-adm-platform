package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

import java.util.List;

public class UserFactory {

    public static User createUser(String name, String email, String phone, String password, Document document,
                                  List<AccountType> accounts, AccountType mainAccount) {
        return new User(UserId.generate(), name, new Email(email), phone, password, document, accounts, mainAccount);
    }

    public static User restoreUser(UserId id, String name, String email, String phone, String password,
                                   Document document, List<AccountType> accounts, AccountType mainAccount) {
        return new User(id, name, new Email(email), phone, password, document, accounts, mainAccount);
    }
}
