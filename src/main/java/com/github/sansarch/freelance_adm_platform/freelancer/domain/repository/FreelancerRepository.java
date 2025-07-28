package com.github.sansarch.freelance_adm_platform.freelancer.domain.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;

public interface FreelancerRepository {

    void save(Freelancer freelancer);

    Freelancer findByEmail(String email);

    Freelancer findById(String id);

    boolean existsByEmail(String email);

    boolean existsById(String id);
}
