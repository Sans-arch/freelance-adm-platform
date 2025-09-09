package com.github.sansarch.freelance_adm_platform.customer.adapters.out.repository.model;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "customers")
@Entity
public class CustomerModel {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    private String document;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    public CustomerModel() {}

    public CustomerModel(Customer customer) {
        this.id = customer.getId().getValue();
        this.name = customer.getName();
        this.email = customer.getEmail().value();
        this.phone = customer.getPhone();
        this.document = customer.getDocument().value();
        this.documentType = customer.getDocument().type();
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

    public String getDocument() {
        return document;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }
}
