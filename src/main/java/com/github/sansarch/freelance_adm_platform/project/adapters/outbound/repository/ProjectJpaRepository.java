package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectJpaRepository extends JpaRepository<Project, UUID> {
}
