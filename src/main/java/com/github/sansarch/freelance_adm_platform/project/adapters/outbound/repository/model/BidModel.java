package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository.model;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.BidStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "bids")
public class BidModel {

    @Id
    private UUID id;

    @Column(name = "project_id", nullable = false, columnDefinition = "uuid")
    private UUID projectId;

    @Column(name = "freelancer_id", nullable = false, columnDefinition = "uuid")
    private UUID freelancerId;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private Integer daysToComplete;

    @Column(name = "proposal_message", columnDefinition = "text")
    private String proposalMessage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BidStatus status = BidStatus.PENDING;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public BidModel() {}

    public BidModel(Bid bid) {
        this.id = bid.getId().getValue();
        this.projectId = bid.getProjectId().getValue();
        this.freelancerId = bid.getFreelancerId().getValue();
        this.amount = bid.getAmount();
        this.daysToComplete = bid.getDaysToComplete();
        this.proposalMessage = bid.getProposalMessage();
        this.status = bid.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public UUID getFreelancerId() {
        return freelancerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getDaysToComplete() {
        return daysToComplete;
    }

    public String getProposalMessage() {
        return proposalMessage;
    }

    public BidStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
