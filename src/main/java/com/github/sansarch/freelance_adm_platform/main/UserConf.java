package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.user.CreateUserUseCase;
import com.github.sansarch.freelance_adm_platform.application.usecase.user.CreateUserUseCaseImpl;
import com.github.sansarch.freelance_adm_platform.infrastructure.repository.UserRepositoryGateway;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.UserJpaRepository;
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
