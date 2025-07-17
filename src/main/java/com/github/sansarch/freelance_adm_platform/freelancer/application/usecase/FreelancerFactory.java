package com.github.sansarch.freelance_adm_platform.freelancer.application.usecase;

import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.freelancer.domain.entity.FreelancerId;

public class FreelancerFactory {

    public static Freelancer createFreelancer(String name, String email, String phone, Document document) {
        return new Freelancer(FreelancerId.generate(), name, email, phone, document);
    }

    public static Freelancer restoreFreelancer(FreelancerId id, String name, String email, String phone, Document document) {
        return new Freelancer(id, name, email, phone, document);
    }
}
