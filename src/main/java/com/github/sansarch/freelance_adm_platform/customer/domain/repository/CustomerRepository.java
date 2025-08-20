package com.github.sansarch.freelance_adm_platform.customer.domain.repository;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(CustomerId id);
    boolean existsByEmail(Email email);
    void deleteById(CustomerId id);
}
