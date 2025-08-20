package com.github.sansarch.freelance_adm_platform.project.domain.enums;

public enum ProjectStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    public static ProjectStatus fromString(String status) {
        for (ProjectStatus ps : ProjectStatus.values()) {
            if (ps.name().equalsIgnoreCase(status)) {
                return ps;
            }
        }
        throw new IllegalArgumentException("Unknown project status: " + status);
    }
}
