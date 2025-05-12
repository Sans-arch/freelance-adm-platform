package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.CreateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConf {

    @Bean
    public CustomerGateway customerGateway() {
        // return new CustomerGatewayImpl();
        return null;
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway) {
        return new CreateCustomerUseCase(customerGateway);
    }
}
