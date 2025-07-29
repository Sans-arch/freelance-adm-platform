package com.github.sansarch.freelance_adm_platform.customer.infra.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "customers")
@Entity
public class CustomerModel {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String document;

    public CustomerModel() {}

    public CustomerModel(UUID id, String name, String email, String phone, String document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
    }
}
