package com.github.sansarch.freelance_adm_platform.infrastructure.repository;

import com.github.sansarch.freelance_adm_platform.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.UserJpaRepository;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.mapper.UserMapper;

public class UserRepositoryGateway implements UserGateway {
    private final UserJpaRepository userJpaRepository;

    public UserRepositoryGateway(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        var userModel = UserMapper.toModel(user);
        var savedUserModel = userJpaRepository.save(userModel);
        return UserMapper.toDomainObject(savedUserModel);
    }
}
