package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidUserDataException;
import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Email;

import java.util.List;

public final class User implements AggregateRoot {
    private final UserId id;
    private String name;
    private Email email;
    private String phone;
    private String password;
    private Document document;
    private List<AccountType> accounts;
    private AccountType mainAccount;

    public User(UserId id, String name, Email email, String phone, String password, Document document,
                List<AccountType> accounts, AccountType mainAccount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.document = document;
        this.accounts = accounts;
        this.mainAccount = mainAccount;
        this.validate();
    }

    public User(String name, Email email, String phone, String password, Document document, List<AccountType> accounts,
                AccountType mainAccount) {
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.document = document;
        this.accounts = accounts;
        this.mainAccount = mainAccount;
        this.validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserDataException("Name cannot be null or empty");
        }
        if (email == null) {
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

    public List<AccountType> getAccounts() {
        return accounts;
    }

    public AccountType getMainAccount() {
        return mainAccount;
    }
}
