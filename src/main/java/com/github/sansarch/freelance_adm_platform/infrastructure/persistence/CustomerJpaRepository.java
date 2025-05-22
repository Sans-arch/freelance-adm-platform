package com.github.sansarch.freelance_adm_platform.infrastructure.persistence;

import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerModel, UUID> {
}
