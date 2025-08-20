package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private final ProjectJpaRepository jpaRepository;

    public ProjectRepositoryImpl(ProjectJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Optional<Project> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public boolean existsByTitle(String name) {
        return false;
    }

    @Override
    public void update(Project project) {

    }
}
