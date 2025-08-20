package com.github.sansarch.freelance_adm_platform.freelancer.application.service;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCase;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.repository.FreelancerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateFreelancerService implements CreateFreelancerUseCase {
    private final FreelancerRepository freelancerRepository;

    public CreateFreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public Freelancer execute(CreateFreelancerCmd cmd) {
        boolean freelancerAlreadyExists = freelancerRepository.existsByEmail(cmd.email());

        if (freelancerAlreadyExists) {
            throw new IllegalArgumentException("Freelancer with email " + cmd.email() + " already exists.");
        }

        Freelancer freelancer = new Freelancer(
                cmd.name(),
                cmd.email(),
                cmd.phone(),
                cmd.document()
        );

        return freelancerRepository.save(freelancer);
    }
}
