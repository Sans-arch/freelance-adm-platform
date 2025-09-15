package com.github.sansarch.freelance_adm_platform.authentication.service.command;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;

public record CreateUserCommand(
    String username,
    String password,
    String fullName,
    String phone,
    Document document,
    String type
) {
}
