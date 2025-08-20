package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.exception.InvalidFreelancerException;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreelancerTest {

    @Test
    void shouldCreateFreelancer() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var freelancer = new Freelancer(
                FreelancerId.generate(),
                name,
                new Email(email),
                phone,
                document
        );

        assertNotNull(freelancer.getId());
        assertEquals(name, freelancer.getName());
        assertEquals(phone, freelancer.getPhone());
        assertNotNull(freelancer.getDocument());
        assertEquals("12345678901", freelancer.getDocument().value());
        assertEquals(DocumentType.CPF, freelancer.getDocument().type());
    }

    @Test
    void shouldCreateFreelancerWithExistingId() {
        var id = FreelancerId.generate();
        String name = "Jane Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";
        Document document = new Document("12345678901", DocumentType.CPF);

        var freelancer = new Freelancer(
                id,
                name,
                new Email(email),
                phone,
                document
        );

        assertEquals(id, freelancer.getId());
        assertEquals(id.getValue(), freelancer.getId().getValue());
        assertEquals(name, freelancer.getName());
        assertEquals(phone, freelancer.getPhone());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(InvalidFreelancerException.class, () ->
                new Freelancer("John", new Email("john@doe.com"), "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        assertThrows(InvalidFreelancerException.class, () ->
                new Freelancer(FreelancerId.generate(), "John Doe", null, "+1234567890", null));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () ->
                new Freelancer(FreelancerId.generate(), "John Doe", new Email("john@doe.com"), "", null));
        assertThrows(InvalidFreelancerException.class, () ->
                new Freelancer(FreelancerId.generate(), "John Doe", new Email("john@doe.com"), null, null));
    }

    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {
        assertThrows(InvalidFreelancerException.class, () ->
                new Freelancer(FreelancerId.generate(), "John Doe", new Email("john@doe.com"), "+1234567890", null));
    }
}