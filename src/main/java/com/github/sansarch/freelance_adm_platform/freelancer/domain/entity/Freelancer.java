package com.github.sansarch.freelance_adm_platform.freelancer.domain.entity;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.exception.InvalidFreelancerException;
import com.github.sansarch.freelance_adm_platform.shared.domain.entity.AggregateRoot;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

public final class Freelancer implements AggregateRoot {
    private final FreelancerId id;
    private final String name;
    private final Email email;
    private final String phone;
    private final Document document;

    public Freelancer(FreelancerId id, String name, Email email, String phone, Document document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.validate();
    }

    public Freelancer(String name, Email email, String phone, Document document) {
        this.id = FreelancerId.generate();
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
        if (email == null) {
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
