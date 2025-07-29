package com.github.sansarch.freelance_adm_platform.shared.domain.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidDocumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void shouldCreateValidDocument() {
        String cpf = "53477565193";
        DocumentType documentType = DocumentType.CPF;
        var result = new Document(cpf, documentType);

        assertNotNull(result);
        assertEquals(cpf, result.value());
        assertEquals(documentType, result.type());
    }

    @Test
    void shouldThrowInvalidDocumentExceptionWhenValueAndTypeAreNull() {
        assertThrows(InvalidDocumentException.class, () -> new Document(null, null));
        assertThrows(InvalidDocumentException.class, () -> new Document("53477565193", null));
        assertThrows(InvalidDocumentException.class, () -> new Document(null, DocumentType.CPF));
        assertThrows(InvalidDocumentException.class, () -> new Document(null, DocumentType.CNPJ));
    }


    @Test
    void shouldThrowInvalidDocumentExceptionWhenValueIsBlank() {
        assertThrows(InvalidDocumentException.class, () -> new Document("", DocumentType.CPF));
        assertThrows(InvalidDocumentException.class, () -> new Document("", DocumentType.CNPJ));
    }
}