package com.github.sansarch.freelance_adm_platform.application.usecase.user;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.dto.CreateUserDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;

public interface CreateUserUseCase {
    User execute(CreateUserDto dto);
}
