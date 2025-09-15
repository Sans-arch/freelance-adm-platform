package com.github.sansarch.freelance_adm_platform.authentication.service;

import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginResponse;
import com.github.sansarch.freelance_adm_platform.authentication.entity.Role;
import com.github.sansarch.freelance_adm_platform.authentication.entity.User;
import com.github.sansarch.freelance_adm_platform.authentication.repository.UserRepository;
import com.github.sansarch.freelance_adm_platform.authentication.service.command.CreateUserCommand;
import com.github.sansarch.freelance_adm_platform.customer.application.usecase.CreateCustomerUseCase;
import com.github.sansarch.freelance_adm_platform.freelancer.application.usecase.CreateFreelancerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateFreelancerUseCase createFreelancerUseCase;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
                       CreateCustomerUseCase createCustomerUseCase, CreateFreelancerUseCase createFreelancerUseCase) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.createCustomerUseCase = createCustomerUseCase;
        this.createFreelancerUseCase = createFreelancerUseCase;
    }

    @Transactional
    public void createUser(CreateUserCommand cmd) {
        if (userRepository.existsByUsername(cmd.username())) {
            throw new IllegalArgumentException("Username is already taken!");
        }

        var user = new User();
        user.setUsername(cmd.username());
        user.setPassword(passwordEncoder.encode(cmd.password()));
        user.setRole(Role.ROLE_USER);

        switch (cmd.type()) {
            case "CUSTOMER" -> createCustomerUseCase.execute(new CreateCustomerUseCase.CreateCustomerCmd(
                    cmd.fullName(),
                    cmd.username(),
                    cmd.phone(),
                    new CreateCustomerUseCase.CreateCustomerCmd.CreateCustomerCmdDocument(
                        cmd.document().value(),
                        cmd.document().type().name()
                    )
                )
            );
            case "FREELANCER" -> createFreelancerUseCase.execute(new CreateFreelancerUseCase.CreateFreelancerCmd(
                    cmd.fullName(),
                    cmd.username(),
                    cmd.phone(),
                    new CreateFreelancerUseCase.CreateFreelancerCmd.Document(
                        cmd.document().value(),
                        cmd.document().type().name()
                    )
            ));
            default -> throw new IllegalArgumentException("Unsupported document type: " + cmd.document().type());
        }

        userRepository.save(user);
    }

    public LoginResponse authenticate(String username, String password) {
        var user = userRepository.findByUsername(username)
            .orElseThrow(() -> new BadCredentialsException("User or password is invalid!"));

        if (!user.isLoginCorrect(password, passwordEncoder)) {
            throw new IllegalArgumentException("Invalid password!");
        }

        if (!user.isLoginCorrect(password, passwordEncoder)) {
            throw new BadCredentialsException("User or password is invalid!");
        }

        var tokenInfo = jwtService.generateToken(user);
        return new LoginResponse(tokenInfo.token(), tokenInfo.expiresIn());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
