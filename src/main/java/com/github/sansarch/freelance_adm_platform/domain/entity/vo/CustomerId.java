package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import java.util.UUID;

public final class CustomerId {
    private final UUID id;

    public CustomerId() {
        this.id = UUID.randomUUID();
    }

    public CustomerId(UUID id) {
        this.id = id;
    }

    public UUID getValue() {
        return id;
    }
}
