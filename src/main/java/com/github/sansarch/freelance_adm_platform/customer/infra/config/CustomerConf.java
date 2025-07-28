package com.github.sansarch.freelance_adm_platform.customer.infra.config;

import com.github.sansarch.freelance_adm_platform.customer.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.customer.infra.repository.CustomerRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.customer.infra.persistence.CustomerJpaRepository;
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
