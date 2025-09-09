package com.github.sansarch.freelance_adm_platform.project.domain.repository;

import com.github.sansarch.freelance_adm_platform.project.domain.entity.Bid;

import java.util.Optional;
import java.util.UUID;

public interface BidRepository {
    Bid save(Bid bid);
    Optional<Bid> findById(UUID id);
    void deleteById(String id);
    boolean existsById(String id);
    boolean existsByTitle(String name);
    void update(Bid bid);
}
