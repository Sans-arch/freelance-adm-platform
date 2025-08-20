package com.github.sansarch.freelance_adm_platform.shared.domain.enums;

public enum DocumentType {
    CPF("CPF"),
    CNPJ("CNPJ");

    private final String value;
    DocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DocumentType fromValue(String value) {
        for (DocumentType type : DocumentType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown document type: " + value);
    }
}
