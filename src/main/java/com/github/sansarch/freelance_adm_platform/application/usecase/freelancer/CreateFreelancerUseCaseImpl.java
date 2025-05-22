package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.dto.CreateFreelancerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;

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
