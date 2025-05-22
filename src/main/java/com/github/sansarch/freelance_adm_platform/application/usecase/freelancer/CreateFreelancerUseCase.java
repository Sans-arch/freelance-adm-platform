package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer;

import com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.dto.CreateFreelancerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;

public interface CreateFreelancerUseCase {
    Freelancer execute(CreateFreelancerDto dto);
}
