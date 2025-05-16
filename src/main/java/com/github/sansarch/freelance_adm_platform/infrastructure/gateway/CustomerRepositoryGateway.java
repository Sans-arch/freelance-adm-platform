package com.github.sansarch.freelance_adm_platform.infrastructure.gateway;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryGateway implements CustomerGateway {
    private final CustomerRepository customerRepository;

    public CustomerRepositoryGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findById(UserId id) {
        return Optional.empty();
    }

    @Override
    public void delete(UserId id) {

    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public void update(Customer customer) {

    }
}
