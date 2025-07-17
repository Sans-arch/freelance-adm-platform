package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidFreelancerException;

public final class Freelancer implements AggregateRoot {
    private final FreelancerId id;
    private String name;
    private String email;
    private String phone;
    private Document document;

    public Freelancer(FreelancerId id, String name, String email, String phone, Document document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new InvalidFreelancerException("Name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new InvalidFreelancerException("Email cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new InvalidFreelancerException("Phone cannot be null or empty");
        }
        if (document == null) {
            throw new InvalidFreelancerException("Document cannot be null");
        }
    }

    public FreelancerId getId() {
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
