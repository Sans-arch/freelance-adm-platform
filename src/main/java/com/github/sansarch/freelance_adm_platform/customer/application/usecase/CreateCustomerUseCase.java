package com.github.sansarch.freelance_adm_platform.customer.application.usecase;

import com.github.sansarch.freelance_adm_platform.customer.application.usecase.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;

public interface CreateCustomerUseCase {
    Customer execute(CreateCustomerDto dto);
}
