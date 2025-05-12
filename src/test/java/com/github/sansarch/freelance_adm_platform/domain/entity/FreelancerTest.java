package com.github.sansarch.freelance_adm_platform.domain.entity;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;
import org.junit.jupiter.api.Test;

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
        var id = FreelancerId.generate();
        String name = "Jane Doe";
        String email = "john@doe.com";
        String phone = "+1234567890";

        var freelancer = new Freelancer(id, name, email, phone);

        assertEquals(id, freelancer.getId());
        assertEquals(name, freelancer.getName());
        assertEquals(email, freelancer.getEmail());
        assertEquals(phone, freelancer.getPhone());
    }
}