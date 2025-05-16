package com.github.sansarch.freelance_adm_platform.application.usecase.user;

import com.github.sansarch.freelance_adm_platform.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.user.dto.CreateUserDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;

public class CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(CreateUserDto dto) {
        var user = new User(
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.document(),
                dto.accounts(),
                dto.mainAccount()
        );
        return userGateway.save(user);
    }
}
