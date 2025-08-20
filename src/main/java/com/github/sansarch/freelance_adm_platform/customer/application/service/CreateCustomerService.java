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
    public Customer execute(CreateCustomerCmd input) {
        boolean customerAlreadyExists  = customerRepository.existsByEmail(input.email());

        if (customerAlreadyExists) {
            throw new IllegalArgumentException("Customer with email " + input.email() + " already exists.");
        }

        Customer customer = new Customer(
            input.name(),
            input.email(),
            input.phone(),
            input.document()
        );

        return customerRepository.save(customer);
    }
}
