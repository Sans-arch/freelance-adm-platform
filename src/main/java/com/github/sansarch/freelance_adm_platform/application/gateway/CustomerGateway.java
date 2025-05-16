package com.github.sansarch.freelance_adm_platform.application.gateway;

import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

    Customer save(Customer customer);
    Optional<Customer> findById(UserId id);
    void delete(UserId id);
    List<Customer> findAll();
    void update(Customer customer);
}
