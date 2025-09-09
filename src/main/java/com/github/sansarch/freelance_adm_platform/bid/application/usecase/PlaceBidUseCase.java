package com.github.sansarch.freelance_adm_platform.bid.application.usecase;

import com.github.sansarch.freelance_adm_platform.bid.application.usecase.PlaceBidUseCase.PlaceBidCmd;
import com.github.sansarch.freelance_adm_platform.bid.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCaseInOut;

import java.math.BigDecimal;

public interface PlaceBidUseCase extends UseCaseInOut<PlaceBidCmd, Bid>, Port {

    record PlaceBidCmd(
            ProjectId projectId,
            FreelancerId freelancerId,
            BigDecimal amount,
            Integer daysToComplete,
            String proposalMessage
    ) {
    }
}
