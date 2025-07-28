package com.github.sansarch.freelance_adm_platform.user.application.usecase.response;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;

import java.util.List;
import java.util.UUID;

public record UserCreatedResponse(
        UUID id,
        String name,
        String email,
        String phone,
        String password,
        Document document,
        List<AccountType> accounts,
        AccountType mainAccount
) {
}
