package com.github.sansarch.freelance_adm_platform.application.usecase.customer;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Email;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(CreateCustomerDto dto) {
        var customer = new Customer(dto.name(), new Email(dto.email()), dto.phone(), dto.document());
        return customerGateway.save(customer);
    }
}
