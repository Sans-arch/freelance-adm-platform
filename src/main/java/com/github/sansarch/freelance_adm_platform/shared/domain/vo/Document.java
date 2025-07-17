package com.github.sansarch.freelance_adm_platform.shared.domain.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidDocumentException;

import java.util.Objects;

public final class Document implements ValueObject {
    private final String value;
    private final DocumentType type;

    public Document(String value, DocumentType type) {
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

    public String getValue() {
        return value;
    }

    public DocumentType getType() {
        return type;
    }

    public boolean isCpf() {
        return type == DocumentType.CPF;
    }

    public boolean isCnpj() {
        return type == DocumentType.CNPJ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Document)) return false;
        Document other = (Document) obj;
        return value.equals(other.value) && type == other.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        return type + ": " + value;
    }
}
