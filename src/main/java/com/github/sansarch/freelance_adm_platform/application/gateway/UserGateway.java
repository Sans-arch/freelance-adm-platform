package com.github.sansarch.freelance_adm_platform.application.gateway;

import com.github.sansarch.freelance_adm_platform.domain.entity.User;

public interface UserGateway {

    User save(User user);
}
