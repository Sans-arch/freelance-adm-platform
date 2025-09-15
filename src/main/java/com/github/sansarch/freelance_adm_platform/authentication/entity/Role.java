package com.github.sansarch.freelance_adm_platform.authentication.entity;

public enum Role {
    ROLE_USER(1),
    ROLE_ADMIN(2);

    private final int code;

    Role(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
