package com.github.sansarch.freelance_adm_platform.infrastructure.gateway;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;

import java.util.List;
import java.util.Optional;

public class FreelancerGatewayImpl implements FreelancerGateway {

    @Override
    public Freelancer save(Freelancer freelancer) {
        return null;
    }

    @Override
    public Optional<Freelancer> findById(FreelancerId id) {
        return Optional.empty();
    }

    @Override
    public void delete(FreelancerId id) {

    }

    @Override
    public List<Freelancer> findAll() {
        return List.of();
    }

    @Override
    public void update(Freelancer freelancer) {

    }
}
