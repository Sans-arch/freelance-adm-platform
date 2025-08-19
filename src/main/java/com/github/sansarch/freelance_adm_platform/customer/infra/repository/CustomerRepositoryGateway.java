package com.github.sansarch.freelance_adm_platform.customer.infra.repository;

import com.github.sansarch.freelance_adm_platform.customer.application.gateway.CustomerGateway;
import com.github.sansarch.freelance_adm_platform.customer.core.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.infra.persistence.CustomerJpaRepository;

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
