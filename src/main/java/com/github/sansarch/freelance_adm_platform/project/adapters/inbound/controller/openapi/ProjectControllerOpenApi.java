package com.github.sansarch.freelance_adm_platform.project.adapters.inbound.controller.openapi;

import com.github.sansarch.freelance_adm_platform.project.adapters.inbound.controller.dto.CreateProjectRequestDto;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Projects", description = "Project management API")
public interface ProjectControllerOpenApi {

    @Operation(summary = "Create a new project")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    Project createProject(@RequestBody(required = true) CreateProjectRequestDto dto);
}
