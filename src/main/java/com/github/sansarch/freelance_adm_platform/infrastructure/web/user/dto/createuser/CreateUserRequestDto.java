package com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateUserRequestDto(
        @NotBlank String name,
        @Email String email,
        @NotBlank String phone,
        @NotEmpty CreateUserRequestDocumentDto document,
        @NotEmpty List<CreateUserRequestAccountType> accounts,
        @NotBlank CreateUserRequestAccountType mainAccount
) {
}
