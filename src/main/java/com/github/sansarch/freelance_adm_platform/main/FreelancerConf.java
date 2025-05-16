package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.FreelancerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.CreateFreelancerUseCase;
import com.github.sansarch.freelance_adm_platform.infrastructure.gateway.FreelancerGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreelancerConf {

    @Bean
    public FreelancerGateway freelancerGateway() {
        return new FreelancerGatewayImpl();
    }

    @Bean
    public CreateFreelancerUseCase createFreelancerUseCase(FreelancerGateway freelancerGateway) {
        return new CreateFreelancerUseCase(freelancerGateway);
    }
}
