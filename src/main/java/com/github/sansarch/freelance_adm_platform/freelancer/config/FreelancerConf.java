package com.github.sansarch.freelance_adm_platform.freelancer.config;

import com.github.sansarch.freelance_adm_platform.freelancer.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.freelancer.infra.repository.FreelancerRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.freelancer.infra.persistence.FreelancerJpaRepository;
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
