package com.github.sansarch.freelance_adm_platform.user.application.gateway;

import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

public interface UserGateway {

    User save(User user);
}
