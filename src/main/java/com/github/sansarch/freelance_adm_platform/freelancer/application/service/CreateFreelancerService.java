package com.github.sansarch.freelance_adm_platform.freelancer.application.service;

import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.repository.FreelancerRepository;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.springframework.stereotype.Service;

@Service
public class CreateFreelancerService implements CreateFreelancerUseCaseInOut {
    private final FreelancerRepository freelancerRepository;

    public CreateFreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public Freelancer execute(CreateFreelancerCmd cmd) {
        boolean freelancerAlreadyExists = freelancerRepository.existsByEmail(new Email(cmd.email()));

        if (freelancerAlreadyExists) {
            throw new IllegalArgumentException("Freelancer with email " + cmd.email() + " already exists.");
        }

        Freelancer freelancer = new Freelancer(
            cmd.name(),
            new Email(cmd.email()),
            cmd.phone(),
            new Document(cmd.document().value(), DocumentType.fromValue(cmd.document().type()))
        );

        return freelancerRepository.save(freelancer);
    }
}
