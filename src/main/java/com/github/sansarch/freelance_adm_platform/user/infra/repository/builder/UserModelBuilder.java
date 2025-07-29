package com.github.sansarch.freelance_adm_platform.user.infra.repository.builder;

import com.github.sansarch.freelance_adm_platform.user.infra.repository.model.UserModel;

import java.util.UUID;

public class UserModelBuilder {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String document;
    private String documentType;

    public UserModelBuilder() {}

    public UserModelBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public UserModelBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserModelBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserModelBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserModelBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserModelBuilder document(String document) {
        this.document = document;
        return this;
    }

    public UserModelBuilder documentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public UserModel build() {
        return new UserModel(id, name, email, phone, password, document, documentType);
    }
}
