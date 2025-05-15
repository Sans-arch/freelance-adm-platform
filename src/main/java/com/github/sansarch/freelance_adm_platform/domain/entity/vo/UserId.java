package com.github.sansarch.freelance_adm_platform.domain.entity.vo;

import java.util.UUID;

public final class UserId {
    private final UUID id;

    private UserId(UUID value) {
        this.id = value;
    }

    public static UserId from(UUID id) {
        return new UserId(id);
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
