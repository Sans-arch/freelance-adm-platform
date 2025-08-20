package com.github.sansarch.freelance_adm_platform.proposal.application.usecase;

import com.github.sansarch.freelance_adm_platform.proposal.domain.entity.Proposal;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.proposal.application.usecase.CreateProposalUseCase.CreateProposalCmd;

public interface CreateProposalUseCase extends UseCase<CreateProposalCmd, Proposal>, Port {

    record CreateProposalCmd(
        String freelancerId,
        String projectId,
        String description,
        String amount
    ) {}
}
