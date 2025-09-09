package com.github.sansarch.freelance_adm_platform.customer.adapters.out.repository;

import com.github.sansarch.freelance_adm_platform.customer.adapters.out.repository.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerModel, UUID> {
    boolean existsByEmail(String email);
}
