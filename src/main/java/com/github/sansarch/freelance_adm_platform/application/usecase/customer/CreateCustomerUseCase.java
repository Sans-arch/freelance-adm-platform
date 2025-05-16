package com.github.sansarch.freelance_adm_platform.application.usecase.customer;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;

public class CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(CreateCustomerDto dto) {
        // Customer customer = new Customer(name, email, phone, document);
        return customerGateway.save(null);
    }
}
