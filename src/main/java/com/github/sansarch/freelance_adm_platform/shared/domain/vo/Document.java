package com.github.sansarch.freelance_adm_platform.shared.domain.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidDocumentException;

public record Document(String value, DocumentType type) implements ValueObject {
    public Document(String value, DocumentType type) {
        if (value == null || type == null) {
            throw new InvalidDocumentException("Value or type cannot be null");
        }

        if (value.isEmpty()) {
            throw new InvalidDocumentException("Value cannot be empty");
        }

        String sanitizedValue = value.replaceAll("\\D", "");

        if (type == DocumentType.CPF && sanitizedValue.length() != 11) {
            throw new InvalidDocumentException("Invalid CPF: " + value);
        }

        if (type == DocumentType.CNPJ && sanitizedValue.length() != 14) {
            throw new InvalidDocumentException("Invalid CNPJ: " + value);
        }

        this.value = sanitizedValue;
        this.type = type;
    }

    public boolean isCpf() {
        return type == DocumentType.CPF;
    }

    public boolean isCnpj() {
        return type == DocumentType.CNPJ;
    }
}
