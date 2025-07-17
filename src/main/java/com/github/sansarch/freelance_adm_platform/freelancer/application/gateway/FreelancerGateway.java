package com.github.sansarch.freelance_adm_platform.freelancer.application.gateway;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;

public interface FreelancerGateway {

    Freelancer save(Freelancer freelancer);
}
