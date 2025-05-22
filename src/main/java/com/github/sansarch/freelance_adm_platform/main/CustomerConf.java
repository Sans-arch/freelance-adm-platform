package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.CreateCustomerUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.infrastructure.repository.CustomerRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.CustomerJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConf {

    @Bean
    public CustomerGateway customerGateway(CustomerJpaRepository customerJpaRepository) {
        return new CustomerRepositoryGateway(customerJpaRepository);
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway) {
        return new CreateCustomerUseCaseImpl(customerGateway);
    }
}
