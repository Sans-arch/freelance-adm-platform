package com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto;

import com.github.sansarch.freelance_adm_platform.bid.domain.entity.Bid;

public record PlaceBidResponse(
    String bidId,
    String projectId,
    String freelancerId,
    Double amount,
    Integer daysToComplete,
    String proposalMessage,
    String status
) {
    public static PlaceBidResponse fromDomain(Bid bid) {
        return new PlaceBidResponse(
                bid.getId().toString(),
                bid.getProjectId().toString(),
                bid.getFreelancerId().toString(),
                bid.getAmount().doubleValue(),
                bid.getDaysToComplete(),
                bid.getProposalMessage(),
                bid.getStatus().name()
        );
    }
}
