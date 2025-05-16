package com.github.sansarch.freelance_adm_platform.infrastructure.gateway;

import com.github.sansarch.freelance_adm_platform.application.gateway.UserGateway;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;

import java.util.List;
import java.util.Optional;

public class UserGatewayImpl implements UserGateway {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(UserId id) {
        return Optional.empty();
    }

    @Override
    public void delete(UserId id) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }
}
