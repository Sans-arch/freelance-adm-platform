package com.github.sansarch.freelance_adm_platform.authentication.controller;

import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginRequest;
import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginResponse;
import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.RegisterRequest;
import com.github.sansarch.freelance_adm_platform.authentication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        userService.createUser(registerRequest.username(), registerRequest.password());
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.authenticate(loginRequest.username(), loginRequest.password());
        return ResponseEntity.ok(loginResponse);
    }
}
