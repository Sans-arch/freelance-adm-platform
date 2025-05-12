package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.CustomerId;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidCustomerException;

public final class Customer {
    private final CustomerId id;
    private String name;
    private String email;
    private String phone;
    private Document document;

    public Customer(String name, String email, String phone, Document document) {
        this.id = CustomerId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.validate();
    }

    public Customer(CustomerId id, String name, String email, String phone, Document document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerException("Name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Document getDocument() {
        return document;
    }
}
