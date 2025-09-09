package com.github.sansarch.freelance_adm_platform.bid.adapters.out.repository;

import com.github.sansarch.freelance_adm_platform.bid.adapters.out.repository.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface BidJpaRepository extends JpaRepository<BidModel, UUID> {

    @Query("""
                SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END
                FROM BidModel b
                WHERE b.projectId = :projectId AND b.freelancerId = :freelancerId
            """)
    boolean existsByProjectIdAndFreelancerId(UUID projectId, UUID freelancerId);
}
