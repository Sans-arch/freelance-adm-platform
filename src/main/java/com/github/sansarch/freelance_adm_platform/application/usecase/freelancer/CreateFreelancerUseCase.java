package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.dto.CreateFreelancerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;

public class CreateFreelancerUseCase {
    private final FreelancerGateway freelancerGateway;

    public CreateFreelancerUseCase(FreelancerGateway freelancerGateway) {
        this.freelancerGateway = freelancerGateway;
    }

    public Freelancer execute(CreateFreelancerDto dto) {
        return null;
    }
}
