package com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.openapi;

import com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto.CreateCustomerRequestDto;
import com.github.sansarch.freelance_adm_platform.customer.adapters.inbound.controller.dto.CreateCustomerResponseDto;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "Customers", description = "Customer management API")
public interface CustomerControllerOpenApi {

    @Operation(summary = "Create a new customer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Customer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<CreateCustomerResponseDto> createCustomer(@RequestBody(required = true) CreateCustomerRequestDto dto);

    @Operation(summary = "Get a customer by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Customer retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    Customer getCustomer(@PathVariable UUID id);
}
