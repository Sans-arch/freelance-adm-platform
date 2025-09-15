package com.github.sansarch.freelance_adm_platform.authentication.controller.dto;

public record RegisterRequest(
    String username,
    String password
) {
}
