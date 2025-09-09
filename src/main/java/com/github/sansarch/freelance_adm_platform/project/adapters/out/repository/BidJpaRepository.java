package com.github.sansarch.freelance_adm_platform.project.adapters.out.repository;

import com.github.sansarch.freelance_adm_platform.project.adapters.out.repository.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BidJpaRepository extends JpaRepository<BidModel, UUID> {
}
