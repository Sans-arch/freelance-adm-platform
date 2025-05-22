package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.CreateFreelancerUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.infrastructure.repository.FreelancerRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.FreelancerJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreelancerConf {

    @Bean
    public FreelancerGateway freelancerGateway(FreelancerJpaRepository freelancerJpaRepository) {
        return new FreelancerRepositoryGateway(freelancerJpaRepository);
    }

    @Bean
    public CreateFreelancerUseCaseImpl createFreelancerUseCase(FreelancerGateway freelancerGateway) {
        return new CreateFreelancerUseCaseImpl(freelancerGateway);
    }
}
