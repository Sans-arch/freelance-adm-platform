package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.AggregateRoot;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidUserDataException;

import java.util.List;

public final class User implements AggregateRoot {
    private final UserId id;
    private String name;
    private String email;
    private String phone;
    private Document document;
    private List<AccountType> accounts;
    private AccountType mainAccount;

    public User(UserId id, String name, String email, String phone, Document document,
                List<AccountType> accounts, AccountType mainAccount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.accounts = accounts;
        this.mainAccount = mainAccount;
        this.validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserDataException("Name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new InvalidUserDataException("Email cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new InvalidUserDataException("Phone cannot be null or empty");
        }
        if (document == null) {
            throw new InvalidUserDataException("Document cannot be null");
        }
    }

    public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Document getDocument() {
        return document;
    }

    public List<AccountType> getAccounts() {
        return accounts;
    }

    public AccountType getMainAccount() {
        return mainAccount;
    }
}
