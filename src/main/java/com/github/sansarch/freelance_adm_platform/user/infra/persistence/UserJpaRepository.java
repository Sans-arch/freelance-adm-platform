package com.github.sansarch.freelance_adm_platform.user.infra.persistence;

import com.github.sansarch.freelance_adm_platform.user.infra.persistence.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserModel, UUID> {
}
