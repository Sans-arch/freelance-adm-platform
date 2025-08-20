package com.github.sansarch.freelance_adm_platform.user.application.service;

import com.github.sansarch.freelance_adm_platform.user.application.usecase.CreateUserUseCase;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(CreateUserCommand cmd) {
        boolean userAlreadyExists  = userRepository.existsByEmail(cmd.email());

        if (userAlreadyExists) {
            throw new IllegalArgumentException("User with email " + cmd.email() + " already exists.");
        }

        User user = new User(
            cmd.name(),
            cmd.email(),
            cmd.phone(),
            cmd.password(),
            cmd.document(),
            cmd.accounts()
        );

        return userRepository.save(user);
    }
}
