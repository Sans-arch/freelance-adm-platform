package com.github.sansarch.freelance_adm_platform.user.application.usecase.command;

import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CreateUserCommand(

        @NotBlank(message = "Name cannot be blank")
        String name,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email cannot be blank")
        String email,

        @NotBlank(message = "Phone cannot be blank")
        String phone,

        @NotBlank(message = "Password cannot be blank")
        String password,

        @NotNull(message = "Document cannot be null")
        Document document,

        @NotEmpty(message = "Accounts cannot be empty")
        Set<AccountType> accounts
) {
}
