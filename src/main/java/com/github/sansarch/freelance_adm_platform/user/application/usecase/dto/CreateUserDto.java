package com.github.sansarch.freelance_adm_platform.user.application.usecase.dto;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;

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
