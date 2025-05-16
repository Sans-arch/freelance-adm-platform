package com.github.sansarch.freelance_adm_platform.application.usecase.user.dto;

public record CreateUserDto(
        String name,
        String email,
        String phone,
        String document
) { }
