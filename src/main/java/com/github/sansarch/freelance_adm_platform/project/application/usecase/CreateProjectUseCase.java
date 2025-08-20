package com.github.sansarch.freelance_adm_platform.project.application.usecase;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCase.CreateProjectCmd;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface CreateProjectUseCase extends UseCase<CreateProjectCmd, Project>, Port {

    record CreateProjectCmd(
            String title,
            String description,
            LocalDateTime dueDate,
            BigDecimal budget,
            UUID customerId
    ) {
    }
}
