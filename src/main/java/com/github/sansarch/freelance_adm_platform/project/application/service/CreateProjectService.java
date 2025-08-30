package com.github.sansarch.freelance_adm_platform.project.application.service;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.CustomerNotFoundException;
import com.github.sansarch.freelance_adm_platform.customer.domain.repository.CustomerRepository;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCase;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class CreateProjectService implements CreateProjectUseCase {
    private final ProjectRepository projectRepository;
    private final CustomerRepository customerRepository;

    public CreateProjectService(ProjectRepository projectRepository, CustomerRepository customerRepository) {
        this.projectRepository = projectRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Project execute(CreateProjectCmd cmd) {
        validateCustomer(cmd.customerId());

        Project project = Project.builder()
                .title(cmd.title())
                .description(cmd.description())
                .dueDate(cmd.dueDate())
                .budget(cmd.budget())
                .customerId(CustomerId.from(cmd.customerId()))
                .build();

        return projectRepository.save(project);
    }

    private void validateCustomer(UUID customerId) {
        if (!customerRepository.existsById(CustomerId.from(customerId))) {
            throw new CustomerNotFoundException(customerId);
        }
    }
}
