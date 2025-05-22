package com.github.sansarch.freelance_adm_platform.application.usecase.customer;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(CreateCustomerDto dto) {
        var customer = new Customer(dto.name(), dto.email(), dto.phone(), dto.document());
        return customerGateway.save(customer);
    }
}
