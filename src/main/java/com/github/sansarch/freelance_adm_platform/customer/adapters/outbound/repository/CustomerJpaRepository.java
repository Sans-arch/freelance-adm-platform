package com.github.sansarch.freelance_adm_platform.customer.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.customer.adapters.outbound.repository.model.CustomerModel;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerModel, CustomerId> {
    boolean existsByEmail(String email);
}
