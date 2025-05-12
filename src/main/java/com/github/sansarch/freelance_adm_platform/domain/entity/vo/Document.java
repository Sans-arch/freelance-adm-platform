package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidDocumentException;

public final class Document {
    private final String value;
    private final DocumentType type;

    public Document(String value, DocumentType type) {
        if (value == null || value.isEmpty()) {
            throw new InvalidDocumentException("Document value cannot be null or empty");
        }

        this.value = sanitize(value);
        this.type = type;
        if (!isValid(this.value, type)) {
            throw new InvalidDocumentException("Invalid " + type + ": " + value);
        }
    }

    private boolean isValid(String value, DocumentType type) {
        return switch (type) {
            case CPF -> isValidCPF(value);
            case CNPJ -> isValidCNPJ(value);
        };
    }

    private String sanitize(String value) {
        return value.replaceAll("\\D", "");
    }

    public static boolean isValidCPF(String cpf) {
        String pattern = "^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$";
        return cpf.matches(pattern);
    }

    public static boolean isValidCNPJ(String cnpj) {
        String pattern = "^(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$";
        return cnpj.matches(pattern);
    }

    public String getValue() {
        return value;
    }

    public DocumentType getType() {
        return type;
    }
}
