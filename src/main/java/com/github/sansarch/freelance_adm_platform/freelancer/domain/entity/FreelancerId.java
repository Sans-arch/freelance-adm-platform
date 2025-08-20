package com.github.sansarch.freelance_adm_platform.freelancer.domain.entity;

import java.util.UUID;

public final class FreelancerId {
    private final UUID id;

    private FreelancerId(UUID id) {
        this.id = id;
    }

    public static FreelancerId from(UUID id) {
        return new FreelancerId(id);
    }

    public static FreelancerId generate() {
        return new FreelancerId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
