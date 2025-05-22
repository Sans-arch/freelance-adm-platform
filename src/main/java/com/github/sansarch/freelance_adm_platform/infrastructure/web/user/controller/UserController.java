package com.github.sansarch.freelance_adm_platform.infrastructure.web.user.controller;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.CreateUserUseCase;
import com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser.CreateUserRequestDto;
import com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser.CreateUserResponseDto;
import com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserDtoMapper userDtoMapper;

    @PostMapping
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        var useCaseDto = userDtoMapper.toInternalCreateUserUseCaseDto(createUserRequestDto);
        var createdCustomer = createUserUseCase.execute(useCaseDto);

        return new CreateUserResponseDto(createdCustomer.getName(), createdCustomer.getEmail());
    }
}
