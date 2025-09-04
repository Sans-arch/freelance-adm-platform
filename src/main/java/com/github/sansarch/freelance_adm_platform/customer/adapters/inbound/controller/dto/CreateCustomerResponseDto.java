package com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto;

import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;

public record CreateCustomerResponseDto(
    String id,
    String name,
    String email,
    String phone,
    CreateCustomerResponseDocumentDto document
) {
    public record CreateCustomerResponseDocumentDto(
        String value,
        DocumentType type
    ) {}

    public static CreateCustomerResponseDto fromDomain(Customer customer) {
        return new CreateCustomerResponseDto(
            customer.getId().getValue().toString(),
            customer.getName(),
            customer.getEmail().value(),
            customer.getPhone(),
            new CreateCustomerResponseDocumentDto(
                customer.getDocument().value(),
                customer.getDocument().type()
            )
        );
    }
}
