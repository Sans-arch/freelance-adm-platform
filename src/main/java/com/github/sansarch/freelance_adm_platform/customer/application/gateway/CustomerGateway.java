package com.github.sansarch.freelance_adm_platform.customer.application.gateway;

import com.github.sansarch.freelance_adm_platform.customer.core.domain.entity.Customer;

public interface CustomerGateway {

    Customer save(Customer customer);
}
