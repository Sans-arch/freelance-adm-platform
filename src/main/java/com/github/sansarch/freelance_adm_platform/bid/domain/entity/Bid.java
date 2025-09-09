package com.github.sansarch.freelance_adm_platform.bid.domain.entity;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;
import com.github.sansarch.freelance_adm_platform.bid.domain.enums.BidStatus;

import java.math.BigDecimal;

public final class Bid {
    private final BidId id;
    private final ProjectId projectId;
    private final FreelancerId freelancerId;
    private final BigDecimal amount;
    private final Integer daysToComplete;
    private final String proposalMessage;
    private final BidStatus status;

    public Bid(BidId id, ProjectId projectId, FreelancerId freelancerId, BigDecimal amount, Integer daysToComplete, String proposalMessage, BidStatus status) {
        this.id = id;
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.daysToComplete = daysToComplete;
        this.proposalMessage = proposalMessage;
        this.status = status;
    }

    public Bid(ProjectId projectId, FreelancerId freelancerId, BigDecimal amount, Integer daysToComplete, String proposalMessage) {
        this.id = BidId.generate();
        this.projectId = projectId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.daysToComplete = daysToComplete;
        this.proposalMessage = proposalMessage;
        this.status = BidStatus.PENDING;
    }

    public BidId getId() {
        return id;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public FreelancerId getFreelancerId() {
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
}
