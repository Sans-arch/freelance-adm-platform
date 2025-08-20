package com.github.sansarch.freelance_adm_platform.customer.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.entity.AggregateRoot;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.InvalidCustomerException;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

public final class Customer implements AggregateRoot {
    private final CustomerId id;
    private final String name;
    private final Email email;
    private final String phone;
    private final Document document;

    public Customer(String name, Email email, String phone, Document document) {
        this.id = CustomerId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        validate();
    }

    public Customer(CustomerId id, String name, Email email, String phone, Document document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerException("Name cannot be null or empty");
        }
        if (email == null) {
            throw new InvalidCustomerException("Email cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new InvalidCustomerException("Phone cannot be null or empty");
        }
        if (document == null) {
            throw new InvalidCustomerException("Document cannot be null");
        }
    }

    public CustomerId getId() {
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

    public Document getDocument() {
        return document;
    }
}
