package com.github.sansarch.freelance_adm_platform.freelancer.domain.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

import java.util.Optional;

public interface FreelancerRepository {
    Freelancer save(Freelancer freelancer);
    Freelancer findByEmail(String email);
    Optional<Freelancer> findById(String id);
    boolean existsByEmail(Email email);
    boolean existsById(String id);
}
