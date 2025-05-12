package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidDocumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void shouldCreateValidCPF() {
        Document document = new Document("12345678909", DocumentType.CPF);
        assertEquals("12345678909", document.getValue());
        assertEquals(DocumentType.CPF, document.getType());
    }

    @Test
    void shouldCreateValidCNPJ() {
        Document document = new Document("12345678000195", DocumentType.CNPJ);
        assertEquals("12345678000195", document.getValue());
        assertEquals(DocumentType.CNPJ, document.getType());
    }

    @Test
    void shouldThrowExceptionWhenCreatingAnInvalidCPF() {
        assertThrows(InvalidDocumentException.class, () -> new Document("423231313", DocumentType.CPF));
    }

    @Test
    void shouldThrowExceptionWhenCreatingAnInvalidCNPJ() {
        assertThrows(InvalidDocumentException.class, () -> new Document("33131121", DocumentType.CNPJ));
    }

    @Test
    void shouldThrowExceptionWhenCreatingWithNullOrEmptyValue() {
        assertThrows(InvalidDocumentException.class, () -> new Document(null, DocumentType.CPF));
        assertThrows(InvalidDocumentException.class, () -> new Document("", DocumentType.CPF));
    }
}