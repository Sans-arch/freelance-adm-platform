package com.github.sansarch.freelance_adm_platform.customer.application.service;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.CustomerAlreadyExists;
import com.github.sansarch.freelance_adm_platform.customer.domain.repository.CustomerRepository;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerUseCaseInOut {
    private final CustomerRepository customerRepository;

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer execute(CreateCustomerCmd cmd) {
        boolean customerAlreadyExists  = customerRepository.existsByEmail(new Email(cmd.email()));

        if (customerAlreadyExists) {
            throw new CustomerAlreadyExists("Customer with email " + cmd.email() + " already exists.");
        }

        Customer customer = new Customer(
            cmd.name(),
            new Email(cmd.email()),
            cmd.phone(),
            new Document(cmd.document().value(), DocumentType.fromValue(cmd.document().type()))
        );

        return customerRepository.save(customer);
    }
}
