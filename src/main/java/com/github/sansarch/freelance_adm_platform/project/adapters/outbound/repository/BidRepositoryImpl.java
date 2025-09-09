package com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.project.adapters.outbound.repository.model.BidModel;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.BidId;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.ProjectId;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.BidRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BidRepositoryImpl implements BidRepository {
    private final BidJpaRepository bidJpaRepository;

    public BidRepositoryImpl(BidJpaRepository bidJpaRepository) {
        this.bidJpaRepository = bidJpaRepository;
    }

    @Override
    public Bid save(Bid bid) {
        BidModel model = new BidModel(bid);
        var persisted = bidJpaRepository.save(model);
        return new Bid(
                ProjectId.from(persisted.getId()),
                FreelancerId.from(persisted.getFreelancerId()),
                persisted.getAmount(),
                persisted.getDaysToComplete(),
                persisted.getProposalMessage()
        );
    }

    @Override
    public Optional<Bid> findById(UUID id) {
        return bidJpaRepository.findById(id).map(
                model -> new Bid(
                        BidId.from(model.getId()),
                        ProjectId.from(model.getProjectId()),
                        FreelancerId.from(model.getFreelancerId()),
                        model.getAmount(),
                        model.getDaysToComplete(),
                        model.getProposalMessage(),
                        model.getStatus()
                )
        );
    }

    @Override
    public void deleteById(String id) {
        // No implementation needed for now
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public boolean existsByTitle(String name) {
        return false;
    }

    @Override
    public void update(Bid bid) {
        // No implementation needed for now
    }
}
