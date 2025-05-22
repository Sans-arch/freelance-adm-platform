package com.github.sansarch.freelance_adm_platform.application.usecase.freelancer;

import com.github.sansarch.freelance_adm_platform.domain.entity.Freelancer;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.FreelancerId;

public class FreelancerFactory {

    public static Freelancer createFreelancer(String name, String email, String phone, Document document) {
        return new Freelancer(FreelancerId.generate(), name, email, phone, document);
    }

    public static Freelancer restoreFreelancer(FreelancerId id, String name, String email, String phone, Document document) {
        return new Freelancer(id, name, email, phone, document);
    }
}
