package com.github.sansarch.freelance_adm_platform.project.domain.entity;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProjectBuilder {
    private String title;
    private String description;
    private ProjectStatus status;
    private LocalDateTime dueDate;
    private BigDecimal budget;
    private CustomerId customerId;

    public ProjectBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder status(ProjectStatus status) {
        this.status = status;
        return this;
    }

    public ProjectBuilder dueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProjectBuilder budget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public ProjectBuilder customerId(CustomerId customerId) {
        this.customerId = customerId;
        return this;
    }

    public Project build() {
        return new Project(title, description, dueDate, budget, customerId);
    }
}
