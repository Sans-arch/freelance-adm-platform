package com.github.sansarch.freelance_adm_platform.freelancer.infra.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "freelancers")
@Entity
public class FreelancerModel {

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

    public FreelancerModel() {}

    public FreelancerModel(String name, String email, String phone, String document) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
    }
}
