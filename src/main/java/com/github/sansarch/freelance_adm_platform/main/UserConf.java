package com.github.sansarch.freelance_adm_platform.main;

import com.github.sansarch.freelance_adm_platform.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.application.usecase.user.CreateUserUseCase;
import com.github.sansarch.freelance_adm_platform.infrastructure.gateway.UserGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConf {

    @Bean
    public UserGateway userGateway() {
        return new UserGatewayImpl();
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway) {
        return new CreateUserUseCase(userGateway);
    }
}
