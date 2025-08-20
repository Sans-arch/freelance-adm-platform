package com.github.sansarch.freelance_adm_platform.customer.application.service;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer execute(CreateCustomerCmd cmd) {
        boolean customerAlreadyExists  = customerRepository.existsByEmail(cmd.email());

        if (customerAlreadyExists) {
            throw new IllegalArgumentException("Customer with email " + cmd.email() + " already exists.");
        }

        Customer customer = new Customer(
            cmd.name(),
            cmd.email(),
            cmd.phone(),
            cmd.document()
        );

        return customerRepository.save(customer);
    }
}
