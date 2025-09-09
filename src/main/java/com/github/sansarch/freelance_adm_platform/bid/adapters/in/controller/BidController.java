package com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller;

import com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto.PlaceBidRequest;
import com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto.PlaceBidResponse;
import com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.openapi.BidControllerOpenApi;
import com.github.sansarch.freelance_adm_platform.bid.application.usecase.PlaceBidUseCase;
import com.github.sansarch.freelance_adm_platform.bid.application.usecase.PlaceBidUseCase.PlaceBidCmd;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/bids")
public class BidController implements BidControllerOpenApi {

    private final PlaceBidUseCase placeBidUseCase;

    public BidController(PlaceBidUseCase placeBidUseCase) {
        this.placeBidUseCase = placeBidUseCase;
    }

    @PostMapping
    @Override
    public ResponseEntity<PlaceBidResponse> placeBid(@PathVariable String projectId, @RequestBody PlaceBidRequest dto) {
        var placedBid = placeBidUseCase.execute(PlaceBidCmd.from(
                UUID.fromString(projectId),
                dto.freelancerId(),
                dto.amount(),
                dto.daysToComplete(),
                dto.proposalMessage()
        ));

        return ResponseEntity.ok(PlaceBidResponse.fromDomain(placedBid));
    }
}
