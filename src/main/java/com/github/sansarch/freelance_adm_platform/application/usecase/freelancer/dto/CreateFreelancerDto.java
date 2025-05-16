package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.dto;

public record CreateFreelancerDto(
        String name,
        String email,
        String phone,
        String document
) { }
