package com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller.dto;

public record CreateFreelancerRequestDto(
    String name,
    String email,
    String phone,
    DocumentDto document
) {
    public record DocumentDto(
        String value,
        String type
    ) {}
}
