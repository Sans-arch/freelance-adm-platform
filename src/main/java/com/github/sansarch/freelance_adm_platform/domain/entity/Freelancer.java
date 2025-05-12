package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidFreelancerException;

public final class Freelancer {
    private final FreelancerId id;
    private String name;
    private String email;
    private String phone;

    public Freelancer(String name, String email, String phone) {
        this.id = FreelancerId.generate();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.validate();
    }

    public Freelancer(FreelancerId id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
}
