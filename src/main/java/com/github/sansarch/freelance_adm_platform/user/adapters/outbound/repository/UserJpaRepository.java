package com.github.sansarch.freelance_adm_platform.user.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.user.adapters.outbound.repository.model.UserModel;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserModel, UserId> {
}
