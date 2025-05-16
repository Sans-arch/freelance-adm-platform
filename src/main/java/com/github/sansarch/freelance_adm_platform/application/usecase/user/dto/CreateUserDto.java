package com.github.sansarch.freelance_adm_platform.application.usecase.user.dto;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;

import java.util.List;

public record CreateUserDto(
        String name,
        String email,
        String phone,
        Document document,
        List<AccountType> accounts,
        AccountType mainAccount
) { }
