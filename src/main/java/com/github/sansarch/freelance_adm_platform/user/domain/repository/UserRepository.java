package com.github.sansarch.freelance_adm_platform.user.domain.repository;

import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

public interface UserRepository {
    void save(User user);

    User findByEmail(String email);

    User findById(String id);

    boolean existsByEmail(String email);

    boolean existsById(String id);
}
