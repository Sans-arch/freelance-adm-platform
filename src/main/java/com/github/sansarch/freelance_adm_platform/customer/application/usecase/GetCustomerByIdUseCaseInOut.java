package com.github.sansarch.freelance_adm_platform.customer.application.usecase;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.GetCustomerByIdUseCaseInOut.GetCustomerByIdCmd;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.Port;
import com.github.sansarch.freelance_adm_platform.shared.application.UseCaseInOut;

import java.util.UUID;

public interface GetCustomerByIdUseCaseInOut extends UseCaseInOut<GetCustomerByIdCmd, Customer>, Port {
    record GetCustomerByIdCmd(UUID id) { }
}
