package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import java.util.UUID;

public final class FreelancerId {
    private final UUID id;

    public FreelancerId(UUID id) {
        this.id = id;
    }

    public UUID getValue() {
        return id;
    }
}
