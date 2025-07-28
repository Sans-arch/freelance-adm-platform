package com.github.sansarch.freelance_adm_platform.user.application.usecase;

import com.github.sansarch.freelance_adm_platform.user.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.command.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.response.UserCreatedResponse;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.factory.UserFactory;

public final class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserCreatedResponse execute(CreateUserCommand dto) {
        User user = UserFactory.createUser(
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.password(),
                dto.document(),
                dto.accounts(),
                dto.mainAccount()
        );

        userGateway.save(user);

        return new UserCreatedResponse(
                user.getId().getValue(),
                user.getName(),
                user.getEmail().getValue(),
                user.getPhone(),
                user.getPassword(),
                user.getDocument(),
                user.getAccounts(),
                user.getMainAccount()
        );
    }
}
