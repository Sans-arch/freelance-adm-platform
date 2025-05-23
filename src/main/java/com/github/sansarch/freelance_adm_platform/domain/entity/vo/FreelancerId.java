package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import java.util.UUID;

public final class FreelancerId {
    private final UUID id;

    private FreelancerId(UUID id) {
        this.id = id;
    }

    public static FreelancerId generate() {
        return new FreelancerId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
