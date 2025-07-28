package com.github.sansarch.freelance_adm_platform.user.adapters.api.createuser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateUserRequestDto(
        @NotBlank String name,
        @Email String email,
        @NotBlank String phone,
        @NotBlank String password,
        @NotEmpty CreateUserRequestDocumentDto document,
        @NotEmpty List<CreateUserRequestAccountType> accounts,
        @NotBlank CreateUserRequestAccountType mainAccount
) {
}
