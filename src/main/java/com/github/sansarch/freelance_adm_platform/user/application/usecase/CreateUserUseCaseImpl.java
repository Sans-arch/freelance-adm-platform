package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.user.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.command.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.response.UserCreatedResponse;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

public final class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserCreatedResponse execute(CreateUserCommand dto) {
        User user = User.builder()
                .name(dto.name())
                .email(dto.email())
                .phone(dto.phone())
                .password(dto.password())
                .document(dto.document())
                .accounts(dto.accounts())
                .build();

        userGateway.save(user);

        return new UserCreatedResponse(
                user.getId().getValue(),
                user.getName(),
                user.getEmail().value(),
                user.getPhone(),
                user.getPassword(),
                user.getDocument(),
                user.getAccounts()
        );
    }
}
