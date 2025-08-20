package com.github.sansarch.freelance_adm_platform.user.adapters.outbound.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "users")
@Entity
public class UserModel {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private String document;

    @Column
    private String documentType;

    public UserModel() {}

    public UserModel(UUID id, String name, String email, String phone, String password, String document, String documentType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.document = document;
        this.documentType = documentType;
    }

    public UUID getId() {
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

    public String getPassword() {
        return password;
    }

    public String getDocument() {
        return document;
    }

    public String getDocumentType() {
        return documentType;
    }
}
