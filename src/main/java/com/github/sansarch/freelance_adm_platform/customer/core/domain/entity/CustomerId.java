package com.github.sansarch.freelance_adm_platform.customer.core.domain.entity;

import java.util.UUID;

public final class CustomerId {
    private final UUID id;

    private CustomerId(UUID id) {
        this.id = id;
    }

    public static CustomerId from(UUID id) {
        return new CustomerId(id);
    }

    public static CustomerId generate() {
        return new CustomerId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
