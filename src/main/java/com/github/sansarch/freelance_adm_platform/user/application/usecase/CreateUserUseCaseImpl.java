package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.user.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.dto.CreateUserDto;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(CreateUserDto dto) {
        var user = UserFactory.createUser(
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.password(),
                dto.document(),
                dto.accounts(),
                dto.mainAccount()
        );

        return userGateway.save(user);
    }
}
