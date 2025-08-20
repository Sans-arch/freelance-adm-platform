package com.github.sansarch.freelance_adm_platform.proposal.domain.entity;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;

import java.math.BigDecimal;

public final class Proposal {
    private final FreelancerId freelancerId;
    private final ProposalId id;
    private final BigDecimal amount;
    private final String description;

    public Proposal(FreelancerId freelancerId, ProposalId id, BigDecimal amount, String description) {
        this.freelancerId = freelancerId;
        this.id = id;
        this.amount = amount;
        this.description = description;
    }
}
