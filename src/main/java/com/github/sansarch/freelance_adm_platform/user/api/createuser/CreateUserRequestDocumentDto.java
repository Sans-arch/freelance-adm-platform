package com.github.sansarch.freelance_adm_platform.user.api.createuser;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDocumentDto(
        @NotBlank String value,
        @NotBlank CreateUserRequestDocumentType type
) {
}
