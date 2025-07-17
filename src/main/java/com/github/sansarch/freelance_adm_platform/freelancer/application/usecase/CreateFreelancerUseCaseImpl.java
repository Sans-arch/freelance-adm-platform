package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.dto.CreateFreelancerDto;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;

public class CreateFreelancerUseCaseImpl implements CreateFreelancerUseCase {
    private final FreelancerGateway freelancerGateway;

    public CreateFreelancerUseCaseImpl(FreelancerGateway freelancerGateway) {
        this.freelancerGateway = freelancerGateway;
    }

    public Freelancer execute(CreateFreelancerDto dto) {
        var freelancer = FreelancerFactory.createFreelancer(dto.name(), dto.email(), dto.phone(), dto.document());
        return freelancerGateway.save(freelancer);
    }
}
