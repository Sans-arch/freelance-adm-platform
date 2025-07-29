package com.github.sansarch.freelance_adm_platform.user.domain.builder;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;

import java.util.Set;

public class UserBuilder {
    private UserId id;
    private String name;
    private Email email;
    private String phone;
    private String password;
    private Document document;
    private Set<AccountType> accounts;

    public UserBuilder() {}

    public UserBuilder id(UserId id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(Email email) {
        this.email = email;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = new Email(email);
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder document(Document document) {
        this.document = document;
        return this;
    }

    public UserBuilder accounts(Set<AccountType> accounts) {
        this.accounts = accounts;
        return this;
    }

    public User build() {
        if (id == null) {
            return new User(name, email, phone, password, document, accounts);
        }
        return new User(id,  name, email, phone, password, document, accounts);
    }
}

