package com.github.sansarch.freelance_adm_platform.project.domain.repository;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;

import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findById(ProjectId id);
    void deleteById(ProjectId id);
    boolean existsById(ProjectId id);
    boolean existsByTitle(String name);
    void update(Project project);
}
