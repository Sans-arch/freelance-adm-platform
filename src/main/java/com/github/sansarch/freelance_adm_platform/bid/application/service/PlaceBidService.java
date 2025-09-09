package com.github.sansarch.freelance_adm_platform.bid.application.service;

import com.github.sansarch.freelance_adm_platform.bid.application.usecase.PlaceBidUseCase;
import com.github.sansarch.freelance_adm_platform.bid.domain.entity.Bid;
import com.github.sansarch.freelance_adm_platform.bid.domain.repository.BidRepository;
import com.github.sansarch.freelance_adm_platform.project.domain.enums.ProjectStatus;
import com.github.sansarch.freelance_adm_platform.project.domain.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PlaceBidService implements PlaceBidUseCase {
    private final BidRepository bidRepository;
    private final ProjectRepository projectRepository;

    public PlaceBidService(BidRepository bidRepository, ProjectRepository projectRepository) {
        this.bidRepository = bidRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public Bid execute(PlaceBidCmd cmd) {
        var project = projectRepository.findById(cmd.projectId()).orElseThrow(() -> new IllegalStateException("Project not found"));

        if (project.getStatus() != ProjectStatus.WAITING_PROPOSAL) {
            throw new IllegalStateException("Cannot place a bid on a project that is not waiting for proposals");
        }

        boolean alreadyBid = bidRepository.existsByProjectIdAndFreelancerId(cmd.projectId(), cmd.freelancerId());
        if (alreadyBid) {
            throw new IllegalStateException("Freelancer has already placed a bid on this project");
        }

        Bid bid = new Bid(cmd.projectId(), cmd.freelancerId(), cmd.amount(), cmd.daysToComplete(), cmd.proposalMessage());
        return bidRepository.save(bid);
    }
}
