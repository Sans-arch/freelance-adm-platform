package com.github.sansarch.freelance_adm_platform.customer.application.usecase;

import com.github.sansarch.freelance_adm_platform.customer.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.customer.core.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

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
