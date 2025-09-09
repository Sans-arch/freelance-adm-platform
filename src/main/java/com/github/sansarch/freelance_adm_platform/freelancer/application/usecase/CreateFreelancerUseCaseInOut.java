package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCaseInOut.CreateFreelancerCmd;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCaseInOut;

public interface CreateFreelancerUseCaseInOut extends UseCaseInOut<CreateFreelancerCmd, Freelancer>, Port {

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
