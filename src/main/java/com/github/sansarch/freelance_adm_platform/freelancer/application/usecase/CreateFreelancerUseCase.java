package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCase.CreateFreelancerCmd;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

public interface CreateFreelancerUseCase extends UseCase<CreateFreelancerCmd, Freelancer>, Port {

    record CreateFreelancerCmd(
            String name,
            Email email,
            String phone,
            Document document
    ) {}
}
