package com.github.sansarch.freelance_adm_platform.application.gateway;

import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;

import java.util.List;
import java.util.Optional;

public interface FreelancerGateway {

    Freelancer save(Freelancer freelancer);
}
