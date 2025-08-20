package com.github.sansarch.freelance_adm_platform.project.adapters.inbound.controller;

import com.github.sansarch.freelance_adm_platform.project.adapters.inbound.controller.dto.CreateProjectRequestDto;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCase;
import com.github.sansarch.freelance_adm_platform.project.application.usecase.CreateProjectUseCase.CreateProjectCmd;
import com.github.sansarch.freelance_adm_platform.project.domain.entity.Project;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final CreateProjectUseCase createProjectUseCase;

    public ProjectController(CreateProjectUseCase createProjectUseCase) {
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
