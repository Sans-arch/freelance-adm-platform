package com.github.sansarch.freelance_adm_platform.freelancer.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.outbound.repository.model.FreelancerModel;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerJpaRepository extends JpaRepository<FreelancerModel, FreelancerId> {
}
