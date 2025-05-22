package com.github.sansarch.freelance_adm_platform.infrastructure.repository;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.FreelancerJpaRepository;

public class FreelancerRepositoryGateway implements FreelancerGateway {
    private final FreelancerJpaRepository freelancerJpaRepository;

    public FreelancerRepositoryGateway(FreelancerJpaRepository freelancerJpaRepository) {
        this.freelancerJpaRepository = freelancerJpaRepository;
    }

    @Override
    public Freelancer save(Freelancer freelancer) {
        return null;
    }
}
