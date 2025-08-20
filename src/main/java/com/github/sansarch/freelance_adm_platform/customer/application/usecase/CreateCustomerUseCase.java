package com.github.sansarch.freelance_adm_platform.customer.application.usecase;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase.CreateCustomerCmd;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;

public interface CreateCustomerUseCase extends UseCase<CreateCustomerCmd, Customer>, Port {

    record CreateCustomerCmd(
        String name,
        Email email,
        String phone,
        Document document
    ) {}
}
