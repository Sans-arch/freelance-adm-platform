package com.github.sansarch.freelance_adm_platform.bid.domain.repository;

import com.github.sansarch.freelance_adm_platform.bid.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;

import java.util.Optional;
import java.util.UUID;

public interface BidRepository {
    Bid save(Bid bid);
    Optional<Bid> findById(UUID id);
    void deleteById(String id);
    boolean existsById(String id);
    boolean existsByTitle(String name);
    void update(Bid bid);
    boolean existsByProjectIdAndFreelancerId(ProjectId projectId, FreelancerId freelancerId);
}
