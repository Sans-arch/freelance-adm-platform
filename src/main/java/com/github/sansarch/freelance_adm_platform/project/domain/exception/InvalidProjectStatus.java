package com.github.sansarch.freelance_adm_platform.project.domain.exception;

public class InvalidProjectStatus extends RuntimeException {
    public InvalidProjectStatus(String message) {
        super(message);
    }
}
