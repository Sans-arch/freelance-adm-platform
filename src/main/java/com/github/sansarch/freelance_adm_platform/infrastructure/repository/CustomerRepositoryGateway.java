package com.github.sansarch.freelance_adm_platform.infrastructure.repository;

import com.github.sansarch.freelance_adm_platform.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.CustomerJpaRepository;

public class CustomerRepositoryGateway implements CustomerGateway {
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryGateway(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }
}
