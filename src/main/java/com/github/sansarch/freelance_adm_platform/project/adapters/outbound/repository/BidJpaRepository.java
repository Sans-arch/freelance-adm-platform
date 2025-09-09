package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BidJpaRepository extends JpaRepository<BidModel, UUID> {
}
