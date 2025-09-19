package com.github.sansarch.freelance_adm_platform.authentication.controller.openapi;

import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginRequest;
import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginResponse;
import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Authentication/Register", description = "Operations related to user authentication and registration")
public interface AuthenticationControllerOpenApi {

    @Operation(summary = "Register a new user", description = "Creates a new user account with the provided details.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<Void> register(@RequestBody(description = "Details for the new user registration") RegisterRequest registerRequest);


    @Operation(summary = "User login", description = "Authenticates a user and returns a JWT token upon successful login.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login successful"),
        @ApiResponse(responseCode = "401", description = "Invalid username or password")
    })
    ResponseEntity<LoginResponse> login(@RequestBody(description = "Payload to authenticate a user") LoginRequest loginRequest);
}
