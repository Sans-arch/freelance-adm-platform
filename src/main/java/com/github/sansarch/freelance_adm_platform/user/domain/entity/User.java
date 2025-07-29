package com.github.sansarch.freelance_adm_platform.user.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.entity.AggregateRoot;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import com.github.sansarch.freelance_adm_platform.user.domain.builder.UserBuilder;
import com.github.sansarch.freelance_adm_platform.user.domain.exception.InvalidUserDataException;

import java.util.Set;

public final class User implements AggregateRoot {
    private final UserId id;
    private final String name;
    private final Email email;
    private final String phone;
    private final String password;
    private final Document document;
    private final Set<AccountType> accounts;

    public User(UserId id, String name, Email email, String phone, String password, Document document,
                Set<AccountType> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.document = document;
        this.accounts = accounts;
        this.validate();
    }

    public User(String name, Email email, String phone, String password, Document document, Set<AccountType> accounts) {
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.document = document;
        this.accounts = accounts;
        this.validate();
    }

    private void validate() {
        if (id == null) {
            throw new InvalidUserDataException("Id cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidUserDataException("Name cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new InvalidUserDataException("Phone cannot be null or empty");
        }
        if (document == null) {
            throw new InvalidUserDataException("Document cannot be null");
        }
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Document getDocument() {
        return document;
    }

    public Set<AccountType> getAccounts() {
        return accounts;
    }
}
