package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository.model.ProjectModel;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private final ProjectJpaRepository projectJpaRepository;

    public ProjectRepositoryImpl(ProjectJpaRepository projectJpaRepository) {
        this.projectJpaRepository = projectJpaRepository;
    }

    @Override
    public Project save(Project project) {
        ProjectModel model = new ProjectModel(project);
        var persisted = projectJpaRepository.save(model);
        return new Project(
                ProjectId.from(persisted.getId()),
                persisted.getTitle(),
                persisted.getDescription(),
                persisted.getStatus(),
                persisted.getDueDate(),
                persisted.getBudget(),
                CustomerId.from(persisted.getCustomerId())
        );
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return projectJpaRepository.findById(id).map(
                model -> new Project(
                        ProjectId.from(model.getId()),
                        model.getTitle(),
                        model.getDescription(),
                        model.getStatus(),
                        model.getDueDate(),
                        model.getBudget(),
                        CustomerId.from(model.getCustomerId())
                )
        );
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
