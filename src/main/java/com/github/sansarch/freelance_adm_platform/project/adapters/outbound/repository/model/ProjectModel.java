package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository.model;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class ProjectModel {

    @Id
    private UUID id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column
    private LocalDateTime deadLine;

    @Column
    private BigDecimal budget;

    @Column
    private UUID customerId;

    public ProjectModel() {}

    public ProjectModel(Project project) {
        this.id = project.getId().getValue();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.status = project.getStatus();
        this.deadLine = project.getDeadLine();
        this.budget = project.getBudget();
        this.customerId = project.getCustomerId().getValue();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
