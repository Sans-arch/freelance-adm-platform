package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.dto.CreateFreelancerDto;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;

public interface CreateFreelancerUseCase {
    Freelancer execute(CreateFreelancerDto dto);
}
