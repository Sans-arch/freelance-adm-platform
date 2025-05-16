package com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto;

public record CreateCustomerDto(
        String name,
        String email,
        String phone,
        String document
) { }
