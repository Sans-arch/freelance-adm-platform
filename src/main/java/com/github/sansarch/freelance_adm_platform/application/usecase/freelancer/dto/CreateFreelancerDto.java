package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer.dto;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;

public record CreateFreelancerDto(
        String name,
        String email,
        String phone,
        Document document
) { }
