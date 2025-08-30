package com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller.openapi;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller.dto.CreateFreelancerRequestDto;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface FreelancerControllerOpenApi {

    @Tag(name = "Freelancers")
    @Operation(summary = "Create a new freelancer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Freelancer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    Freelancer createFreelancer(@RequestBody(required = true) CreateFreelancerRequestDto dto);
}
