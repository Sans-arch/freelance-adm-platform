package com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller.dto.CreateFreelancerRequestDto;
import com.github.sansarch.freelance_adm_platform.freelancer.adapters.inbound.controller.openapi.FreelancerControllerOpenApi;
import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCase;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.DriverAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/freelancers")
public class FreelancerController implements FreelancerControllerOpenApi, DriverAdapter {
    private final CreateFreelancerUseCase createFreelancerUseCase;

    public FreelancerController(CreateFreelancerUseCase createFreelancerUseCase) {
        this.createFreelancerUseCase = createFreelancerUseCase;
    }

    @PostMapping
    public Freelancer createFreelancer(@RequestBody CreateFreelancerRequestDto dto) {
        return this.createFreelancerUseCase.execute(
            new CreateFreelancerUseCase.CreateFreelancerCmd(
                dto.name(),
                dto.email(),
                dto.phone(),
                new CreateFreelancerUseCase.CreateFreelancerCmd.Document(dto.document().value(), dto.document().type())
            )
        );
    }
}
