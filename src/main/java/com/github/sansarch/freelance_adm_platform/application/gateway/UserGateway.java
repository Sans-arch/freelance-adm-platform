package com.github.sansarch.freelance_adm_platform.application.gateway;

import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    User save(User user);
    Optional<User> findById(UserId id);
    void delete(UserId id);
    List<User> findAll();
    void update(User user);
}
