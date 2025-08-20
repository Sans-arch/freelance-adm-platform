package com.github.sansarch.freelance_adm_platform.project.adapters.inbound.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateProjectRequestDto(
    String title,
    String description,
    LocalDateTime dueDate,
    BigDecimal budget,
    UUID customerId
) {
}
