package com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PlaceBidRequest(
        UUID freelancerId,
        BigDecimal amount,
        Integer daysToComplete,
        String proposalMessage
) {
}
