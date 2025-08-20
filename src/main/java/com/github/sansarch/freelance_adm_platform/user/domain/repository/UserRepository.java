package com.github.sansarch.freelance_adm_platform.user.domain.repository;

import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
    User findById(String id);
    boolean existsByEmail(Email email);
    boolean existsById(String id);
}
