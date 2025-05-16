package com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;

public record CreateCustomerDto(
        String name,
        String email,
        String phone,
        Document document
) { }
