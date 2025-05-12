package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;

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
    }

    public Freelancer(FreelancerId id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
