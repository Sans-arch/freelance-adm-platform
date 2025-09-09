package com.github.sansarch.freelance_adm_platform.customer.adapters.in.controller;

import com.github.sansarch.freelance_adm_platform.customer.adapters.in.controller.dto.CreateCustomerRequestDto;
import com.github.sansarch.freelance_adm_platform.customer.adapters.in.controller.dto.CreateCustomerResponseDto;
import com.github.sansarch.freelance_adm_platform.customer.adapters.in.controller.openapi.CustomerControllerOpenApi;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCaseInOut.CreateCustomerCmd;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCaseInOut.CreateCustomerCmd.CreateCustomerCmdDocument;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.GetCustomerByIdUseCaseInOut;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.GetCustomerByIdUseCaseInOut.GetCustomerByIdCmd;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.shared.DriverAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController implements CustomerControllerOpenApi, DriverAdapter {
    private final CreateCustomerUseCaseInOut createCustomerUseCase;
    private final GetCustomerByIdUseCaseInOut getCustomerByIdUseCase;

    public CustomerController(CreateCustomerUseCaseInOut createCustomerUseCase,
                              GetCustomerByIdUseCaseInOut getCustomerByIdUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> createCustomer(@RequestBody CreateCustomerRequestDto dto) {
        var customer = this.createCustomerUseCase.execute(
            new CreateCustomerCmd(
                dto.name(),
                dto.email(),
                dto.phone(),
                new CreateCustomerCmdDocument(dto.document().value(), dto.document().type())
            )
        );

        return ResponseEntity.ok(CreateCustomerResponseDto.fromDomain(customer));
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable UUID id) {
       return this.getCustomerByIdUseCase.execute(new GetCustomerByIdCmd(id));
    }
}
