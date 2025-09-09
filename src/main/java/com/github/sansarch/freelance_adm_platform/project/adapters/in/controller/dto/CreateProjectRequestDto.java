package com.github.sansarch.freelance_adm_platform.project.adapters.in.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateProjectRequestDto(
    String title,
    String description,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(
        example = "2025-12-31 23:59:59",
        description = "Deadline in the format yyyy-MM-dd HH:mm:ss"
    )
    LocalDateTime deadLine,

    BigDecimal budget,
    UUID customerId
) {
}
