package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import com.github.sansarch.freelance_adm_platform.domain.exception.InvalidFreelancerException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FreelancerTest {

    @Test
    void shouldCreateNewFreelancer() {
        String name = "John Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";

        var freelancer = new Freelancer(name, email, phone);

        assertNotNull(freelancer.getId());
        assertEquals(name, freelancer.getName());
        assertEquals(email, freelancer.getEmail());
        assertEquals(phone, freelancer.getPhone());
    }

    @Test
    void shouldCreateFreelancerWithExistingId() {
        UUID uuid = UUID.randomUUID();
        var id = FreelancerId.from(uuid);
        String name = "Jane Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";

        var freelancer = new Freelancer(id, name, email, phone);

        assertEquals(id, freelancer.getId());
        assertEquals(id.getValue(), freelancer.getId().getValue());
        assertEquals(name, freelancer.getName());
        assertEquals(email, freelancer.getEmail());
        assertEquals(phone, freelancer.getPhone());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("", "john@doe.com", "+1234567890"));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer(null, "john@doe.com", "+1234567890"));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "", "+1234567890"));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", null, "+1234567890"));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsNullOrEmpty() {
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "john@doe.com", ""));
        assertThrows(InvalidFreelancerException.class, () -> new Freelancer("John Doe", "john@doe.com", null));
    }
}