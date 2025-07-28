package com.github.sansarch.freelance_adm_platform.user.infra.repository;

import com.github.sansarch.freelance_adm_platform.user.infra.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserModel, UUID> {
}
