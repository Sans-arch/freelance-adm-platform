package com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateCustomerRequestDto(

    @NotBlank
    @Size(min = 1, max = 255)
    String name,

    @NotBlank
    @Size(min = 5, max = 255)
    String email,

    @NotBlank
    @Size(min = 10, max = 20)
    String phone,

    @NotEmpty
    DocumentDto document
) {
    public record DocumentDto(
        String value,
        String type
    ) {}
}
