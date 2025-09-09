package com.github.sansarch.freelance_adm_platform.project.adapters.in.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateProjectRequestDto(
    String title,
    String description,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dueDate,

    BigDecimal budget,
    UUID customerId
) {
}
