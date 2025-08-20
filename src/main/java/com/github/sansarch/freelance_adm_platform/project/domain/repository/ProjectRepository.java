package com.github.sansarch.freelance_adm_platform.project.domain.repository;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findById(UUID id);
    void deleteById(String id);
    boolean existsById(String id);
    boolean existsByTitle(String name);
    void update(Project project);
}
