package com.github.sansarch.freelance_adm_platform.application.usecase.user.dto;

import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.AccountType;

import java.util.List;

public record CreateUserDto(
        String name,
        String email,
        String phone,
        String password,
        Document document,
        List<AccountType> accounts,
        AccountType mainAccount
) { }
