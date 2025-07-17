package com.github.sansarch.freelance_adm_platform.customer.application.usecase.dto;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;

public record CreateCustomerDto(
        String name,
        String email,
        String phone,
        Document document
) { }
