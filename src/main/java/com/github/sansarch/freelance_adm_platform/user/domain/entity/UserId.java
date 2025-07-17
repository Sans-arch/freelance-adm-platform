package com.github.sansarch.freelance_adm_platform.user.domain.entity;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.ValueObject;

import java.util.UUID;

public final class UserId implements ValueObject {
    private final UUID id;

    private UserId(UUID value) {
        this.id = value;
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    public static UserId from(UUID value) {
        return new UserId(value);
    }

    public UUID getValue() {
        return id;
    }
}
