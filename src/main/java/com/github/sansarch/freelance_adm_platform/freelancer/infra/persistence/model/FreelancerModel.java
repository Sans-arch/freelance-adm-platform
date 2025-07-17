package com.github.sansarch.freelance_adm_platform.freelancer.infra.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
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
}
