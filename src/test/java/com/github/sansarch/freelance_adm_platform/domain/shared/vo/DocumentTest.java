package com.github.sansarch.freelance_adm_platform.domain.shared.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidDocumentException;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void shouldCreateValidCPF() {
        Document document = new Document("12345678901", DocumentType.CPF);
        assertEquals("12345678901", document.getValue());
        assertTrue(document.isCpf());
        assertFalse(document.isCnpj());
    }

    @Test
    void shouldCreateValidCNPJ() {
        Document document = new Document("12345678000195", DocumentType.CNPJ);
        assertEquals("12345678000195", document.getValue());
        assertFalse(document.isCpf());
        assertTrue(document.isCnpj());
    }

    @Test
    void shouldThrowInvalidDocumentExceptionWhenCPFIsinvalid() {
        assertThrows(InvalidDocumentException.class, () -> new Document("1234567890", DocumentType.CPF));
    }

    @Test
    void shouldThrowInvalidDocumentExceptionWhenCNPJIsinvalid() {
        assertThrows(InvalidDocumentException.class, () -> new Document("1234567800019", DocumentType.CNPJ));
    }
}