package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.dto;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;

public record CreateFreelancerDto(
        String name,
        String email,
        String phone,
        Document document
) { }
