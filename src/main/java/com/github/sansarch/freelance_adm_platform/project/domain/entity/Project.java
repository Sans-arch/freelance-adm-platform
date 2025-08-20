package com.github.sansarch.freelance_adm_platform.project.domain.entity;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;

public final class Project {
    private final ProjectId id;
    private String name;
    private String description;
    private ProjectStatus status;
    private final CustomerId customerId;

    public Project(ProjectId id, String name, String description, ProjectStatus status, CustomerId customerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.customerId = customerId;
        validate();
    }

    public Project(String name, String description, CustomerId customerId) {
        this.id = ProjectId.generate();
        this.name = name;
        this.description = description;
        this.status = ProjectStatus.PENDING;
        this.customerId = customerId;
        validate();
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Project description cannot be null or empty");
        }
        if (status == null) {
            throw new IllegalArgumentException("Project status cannot be null");
        }
    }
}
