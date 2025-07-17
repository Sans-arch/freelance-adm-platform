package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.user.application.usecase.dto.CreateUserDto;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

public interface CreateUserUseCase {
    User execute(CreateUserDto dto);
}
