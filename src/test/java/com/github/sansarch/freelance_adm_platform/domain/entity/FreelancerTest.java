package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidFreelancerException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FreelancerTest {

    @Test
    void shouldCreateFreelancer() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var freelancer = new Freelancer(name, email, phone, document);

        assertNotNull(freelancer.getId());
        assertEquals(name, freelancer.getName());
        assertEquals(email, freelancer.getEmail());
        assertEquals(phone, freelancer.getPhone());
        assertNotNull(freelancer.getDocument());
        assertEquals("12345678901", freelancer.getDocument().getValue());
        assertEquals(DocumentType.CPF, freelancer.getDocument().getType());
    }

    @Test
    void shouldCreateFreelancerWithExistingId() {
        var id = FreelancerId.from(UUID.randomUUID());
        String name = "Jane Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var freelancer = new Freelancer(id, name, email, phone, document);

        assertEquals(id, freelancer.getId());
        assertEquals(id.getValue(), freelancer.getId().getValue());
        assertEquals(name, freelancer.getName());
        assertEquals(email, freelancer.getEmail());
        assertEquals(phone, freelancer.getPhone());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("", "john@doe.com", "+1234567890", null));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer(null, "john@doe.com", "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "", "+1234567890", null));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", null, "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "john@doe.com", "", null));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "john@doe.com", null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "john@doe.com", "+1234567890", null));
    }
}