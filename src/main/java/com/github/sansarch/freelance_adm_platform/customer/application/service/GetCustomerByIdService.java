package com.github.sansarch.freelance_adm_platform.customer.application.service;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.GetCustomerByIdUseCase;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.CustomerNotFoundException;
import com.github.sansarch.freelance_adm_platform.customer.domain.repository.CustomerRepository;
import com.github.sansarch.freelance_adm_platform.shared.DriverAdapter;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerByIdService implements GetCustomerByIdUseCase, DriverAdapter {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer execute(GetCustomerByIdCmd cmd) {
        return customerRepository.findById(CustomerId.from(cmd.id()))
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + cmd.id()));
    }
}
