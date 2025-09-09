package com.github.sansarch.freelance_adm_platform.project.adapters.in.controller;

import com.github.sansarch.freelance_adm_platform.project.adapters.in.controller.dto.CreateProjectRequestDto;
import com.github.sansarch.freelance_adm_platform.project.adapters.in.controller.openapi.ProjectControllerOpenApi;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCaseInOut.CreateProjectCmd;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import com.github.sansarch.freelance_adm_platform.shared.DriverAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController implements ProjectControllerOpenApi, DriverAdapter {
    private final CreateProjectUseCaseInOut createProjectUseCase;

    public ProjectController(CreateProjectUseCaseInOut createProjectUseCase) {
        this.createProjectUseCase = createProjectUseCase;
    }

    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequestDto dto) {
        var cmd = new CreateProjectCmd(
            dto.title(),
            dto.description(),
            dto.dueDate(),
            dto.budget(),
            dto.customerId()
        );
        return createProjectUseCase.execute(cmd);
    }
}
