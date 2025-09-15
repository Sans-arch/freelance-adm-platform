package com.github.sansarch.freelance_adm_platform.authentication.controller.dto;

import com.github.sansarch.freelance_adm_platform.authentication.service.command.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;

public record RegisterRequest(
    String username,
    String password,
    String fullName,
    String phone,
    Document document,
    String type
) {
    public CreateUserCommand convertToCommand() {
        return new CreateUserCommand(
            this.username,
            this.password,
            this.fullName,
            this.phone,
            this.document,
            this.type
        );
    }
}
