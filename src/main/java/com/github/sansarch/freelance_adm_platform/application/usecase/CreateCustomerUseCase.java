package com.github.sansarch.freelance_adm_platform.application.usecase;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;

public class CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        return customerGateway.save(customer);
    }
}
