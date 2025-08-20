package com.github.sansarch.freelance_adm_platform.project.domain.entity;

import java.util.UUID;

public final class ProjectId {
    private final UUID id;

    private ProjectId(UUID id) {
        this.id = id;
    }

    public static ProjectId from(UUID id) {
        return new ProjectId(id);
    }

    public static ProjectId generate() {
        return new ProjectId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
