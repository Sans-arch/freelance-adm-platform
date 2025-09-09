package com.github.sansarch.freelance_adm_platform.freelancer.adapters.out.repository.model;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "freelancers")
@Entity
public class FreelancerModel {

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

    public FreelancerModel() {}

    public FreelancerModel(String name, String email, String phone, Document document) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document.value();
        this.documentType = document.type();
    }

    public FreelancerModel(Freelancer freelancer) {
        this.id = freelancer.getId().getValue();
        this.name = freelancer.getName();
        this.email = freelancer.getEmail().value();
        this.phone = freelancer.getPhone();
        this.document = freelancer.getDocument().value();
        this.documentType = freelancer.getDocument().type();
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
