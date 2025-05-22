package com.github.sansarch.freelance_adm_platform.application.usecase.customer;

import com.github.sansarch.freelance_adm_platform.application.usecase.customer.dto.CreateCustomerDto;
import com.github.sansarch.freelance_adm_platform.domain.entity.Customer;

public interface CreateCustomerUseCase {
    Customer execute(CreateCustomerDto dto);
}
