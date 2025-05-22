package com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDocumentDto(
        @NotBlank String value,
        @NotBlank CreateUserRequestDocumentType type
) {
}
