package com.github.sansarch.freelance_adm_platform.customer.application.usecase;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.GetCustomerByIdUseCase.GetCustomerByIdCmd;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCase;

import java.util.UUID;

public interface GetCustomerByIdUseCase extends UseCase<GetCustomerByIdCmd, Customer>, Port {
    record GetCustomerByIdCmd(UUID id) { }
}
