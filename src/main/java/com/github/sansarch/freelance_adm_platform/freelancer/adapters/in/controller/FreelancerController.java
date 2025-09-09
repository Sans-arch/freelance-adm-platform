package com.github.sansarch.freelance_adm_platform.freelancer.adapters.in.controller;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.in.controller.dto.CreateFreelancerRequestDto;
import com.github.sansarch.freelance_adm_platform.freelancer.adapters.in.controller.openapi.FreelancerControllerOpenApi;
import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.DriverAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/freelancers")
public class FreelancerController implements FreelancerControllerOpenApi, DriverAdapter {
    private final CreateFreelancerUseCaseInOut createFreelancerUseCase;

    public FreelancerController(CreateFreelancerUseCaseInOut createFreelancerUseCase) {
        this.createFreelancerUseCase = createFreelancerUseCase;
    }

    @PostMapping
    public Freelancer createFreelancer(@RequestBody CreateFreelancerRequestDto dto) {
        return this.createFreelancerUseCase.execute(
            new CreateFreelancerUseCaseInOut.CreateFreelancerCmd(
                dto.name(),
                dto.email(),
                dto.phone(),
                new CreateFreelancerUseCaseInOut.CreateFreelancerCmd.Document(dto.document().value(), dto.document().type())
            )
        );
    }
}
