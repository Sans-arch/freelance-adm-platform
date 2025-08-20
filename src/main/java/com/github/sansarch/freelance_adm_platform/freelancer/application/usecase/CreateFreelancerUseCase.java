package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCase.CreateFreelancerCmd;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;

public interface CreateFreelancerUseCase extends UseCase<CreateFreelancerCmd, Freelancer>, Port {

    record CreateFreelancerCmd(
            String name,
            String email,
            String phone,
            Document document
    ) {
        public record Document(
                String value,
                String type
        ) { }
    }
}
