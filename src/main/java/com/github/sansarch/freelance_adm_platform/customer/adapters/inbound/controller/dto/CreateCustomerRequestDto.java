package com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto;

public record CreateCustomerRequestDto(
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
