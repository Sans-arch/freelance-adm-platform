package com.github.sansarch.freelance_adm_platform.freelancer.infra.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.freelancer.infra.persistence.FreelancerJpaRepository;

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
