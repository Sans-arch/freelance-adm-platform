package com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller;

import com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto.CreateCustomerRequestDto;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase.CreateCustomerCmd;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.DrivingAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController implements DrivingAdapter {
    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequestDto dto) {
        return this.createCustomerUseCase.execute(
            new CreateCustomerCmd(
                dto.name(),
                dto.email(),
                dto.phone(),
                new CreateCustomerCmd.Document(dto.document().value(), dto.document().type())
            )
        );
    }
}
