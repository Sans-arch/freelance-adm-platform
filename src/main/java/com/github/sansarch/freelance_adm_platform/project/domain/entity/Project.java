package com.github.sansarch.freelance_adm_platform.project.domain.entity;

import com.github.sansarch.freelance_adm_platform.bid.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;
import com.github.sansarch.freelance_adm_platform.project.domain.exception.InvalidProjectException;
import com.github.sansarch.freelance_adm_platform.shared.domain.entity.AggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public final class Project implements AggregateRoot {
    private final ProjectId id;
    private final String title;
    private final String description;
    private final ProjectStatus status;
    private final LocalDateTime deadLine;
    private final BigDecimal budget;
    private final CustomerId customerId;
    private final Set<Bid> bids;

    public Project(ProjectId id, String title, String description, ProjectStatus status, LocalDateTime deadLine, BigDecimal budget, CustomerId customerId, Set<Bid> bids) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadLine = deadLine;
        this.budget = budget;
        this.customerId = customerId;
        this.bids = bids;
        validate();
    }

    public Project(String title, String description, LocalDateTime deadLine, BigDecimal budget, CustomerId customerId, Set<Bid> bids) {
        this.id = ProjectId.generate();
        this.title = title;
        this.description = description;
        this.status = ProjectStatus.PENDING;
        this.deadLine = deadLine;
        this.budget = budget;
        this.customerId = customerId;
        this.bids = bids;
        validate();
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    private void validate() {
        if (title == null || title.isEmpty()) {
            throw new InvalidProjectException("Project name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new InvalidProjectException("Project description cannot be null or empty");
        }
        if (status == null) {
            throw new InvalidProjectException("Project status cannot be null");
        }
        if (deadLine == null) {
            throw new InvalidProjectException("Project deadLine cannot be null");
        }
        if (budget == null || budget.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidProjectException("Project budget cannot be null or negative");
        }
    }

    public ProjectId getId() {
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

    public CustomerId getCustomerId() {
        return customerId;
    }

    public BigDecimal getBudget() {
        return budget;
    }
}
