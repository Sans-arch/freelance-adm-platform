package com.github.sansarch.freelance_adm_platform.project.application.service;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCase;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateProjectService implements CreateProjectUseCase {
    private final ProjectRepository projectRepository;

    public CreateProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project execute(CreateProjectCmd cmd) {
        Project project = Project.builder()
                .title(cmd.title())
                .description(cmd.description())
                .dueDate(cmd.dueDate())
                .budget(cmd.budget())
                .customerId(CustomerId.from(cmd.customerId()))
                .build();

        return projectRepository.save(project);
    }
}
