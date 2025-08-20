package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.command.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.response.UserCreatedResponse;

public interface CreateUserUseCase extends UseCase<CreateUserCommand, UserCreatedResponse> {
    UserCreatedResponse execute(CreateUserCommand command);
}
