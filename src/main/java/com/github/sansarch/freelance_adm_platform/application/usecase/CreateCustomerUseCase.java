package com.github.sansarch.freelance_adm_platform.application.usecase;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;

public class CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(String name, String email, String phone, Document document) {
        Customer customer = new Customer(name, email, phone, document);
        return customerGateway.save(customer);
    }
}
