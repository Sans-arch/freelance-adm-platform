package com.github.sansarch.freelance_adm_platform.freelancer.adapters.out.repository;

import com.github.sansarch.freelance_adm_platform.freelancer.adapters.out.repository.model.FreelancerModel;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.repository.FreelancerRepository;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FreelancerRepositoryImpl implements FreelancerRepository {
    private final FreelancerJpaRepository freelancerJpaRepository;

    public FreelancerRepositoryImpl(FreelancerJpaRepository freelancerJpaRepository) {
        this.freelancerJpaRepository = freelancerJpaRepository;
    }

    @Override
    public Freelancer save(Freelancer freelancer) {
        FreelancerModel model = new FreelancerModel(freelancer);
        var persisted = freelancerJpaRepository.save(model);
        return new Freelancer(
                FreelancerId.from(persisted.getId()),
                persisted.getName(),
                new Email(persisted.getEmail()),
                persisted.getPhone(),
                new Document(persisted.getDocument(), persisted.getDocumentType())
        );
    }

    @Override
    public Freelancer findByEmail(String email) {
        return null;
    }

    @Override
    public Optional<Freelancer> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(Email email) {
        return false;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }
}
