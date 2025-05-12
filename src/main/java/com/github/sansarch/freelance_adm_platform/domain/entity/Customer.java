package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.CustomerId;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidCustomerException;

public final class Customer {
    private final CustomerId id;
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.id = CustomerId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.validate();
    }

    public Customer(CustomerId id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
}
