package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.infrastructure.gateway.CustomerRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConf {

    @Bean
    public CustomerGateway customerGateway(CustomerRepository customerRepository) {
        return new CustomerRepositoryGateway(customerRepository);
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway) {
        return new CreateCustomerUseCase(customerGateway);
    }
}
