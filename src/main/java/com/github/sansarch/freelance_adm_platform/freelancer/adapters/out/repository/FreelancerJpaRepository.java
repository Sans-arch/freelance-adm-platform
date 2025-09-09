package com.github.sansarch.freelance_adm_platform.freelancer.adapters.out.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.out.repository.model.FreelancerModel;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerJpaRepository extends JpaRepository<FreelancerModel, FreelancerId> {
}
