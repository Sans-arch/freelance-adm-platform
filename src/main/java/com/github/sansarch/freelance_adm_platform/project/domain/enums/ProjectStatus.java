package com.github.sansarch.freelance_adm_platform.project.domain.enums;

import com.github.sansarch.freelance_adm_platform.project.domain.exception.InvalidProjectStatus;

public enum ProjectStatus {
    PENDING,
    WAITING_PROPOSAL,
    COMPLETED,
    CANCELLED;

    public static ProjectStatus fromString(String status) {
        for (ProjectStatus ps : ProjectStatus.values()) {
            if (ps.name().equalsIgnoreCase(status)) {
                return ps;
            }
        }
        throw new InvalidProjectStatus("Unknown project status: " + status);
    }
}
