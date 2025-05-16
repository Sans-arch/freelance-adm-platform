package com.github.sansarch.freelance_adm_platform.infrastructure.persistence;

import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
