package com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.openapi;

import com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto.PlaceBidRequest;
import com.github.sansarch.freelance_adm_platform.bid.adapters.in.controller.dto.PlaceBidResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Bids", description = "Bid management API")
public interface BidControllerOpenApi {

    @Operation(summary = "Place a new bid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bid placed successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<PlaceBidResponse> placeBid(String projectId, @RequestBody(required = true) PlaceBidRequest dto);
}
