package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.CreateUserUseCase.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

import java.util.Set;

public interface CreateUserUseCase extends UseCase<CreateUserCommand, User>, Port {
    record CreateUserCommand(
            String name,
            String email,
            String phone,
            String password,
            Document document,
            Set<AccountType> accounts
    ) {
    }
}
