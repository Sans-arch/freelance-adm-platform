package com.github.sansarch.freelance_adm_platform.user.infra.config;

import com.github.sansarch.freelance_adm_platform.user.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.CreateUserUseCase;
import com.github.sansarch.freelance_adm_platform.user.application.usecase.CreateUserUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.user.infra.repository.UserRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.user.infra.repository.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConf {

    @Bean
    public UserGateway userGateway(UserJpaRepository userJpaRepository) {
        return new UserRepositoryGateway(userJpaRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway) {
        return new CreateUserUseCaseImpl(userGateway);
    }
}
