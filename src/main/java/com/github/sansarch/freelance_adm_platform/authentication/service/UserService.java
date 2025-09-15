package com.github.sansarch.freelance_adm_platform.authentication.service;

import com.github.sansarch.freelance_adm_platform.authentication.controller.dto.LoginResponse;
import com.github.sansarch.freelance_adm_platform.authentication.entity.Role;
import com.github.sansarch.freelance_adm_platform.authentication.entity.User;
import com.github.sansarch.freelance_adm_platform.authentication.repository.RoleRepository;
import com.github.sansarch.freelance_adm_platform.authentication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public void createUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username is already taken!");
        }

        var role = roleRepository.findByName(Role.Values.ROLE_USER.name())
            .orElseThrow(() -> new IllegalArgumentException("Role is not found!"));

        var user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of(role));
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

        var tokenInfo = jwtService.generateToken(user.getId().toString());
        return new LoginResponse(tokenInfo.token(), tokenInfo.expiresIn());
    }
}
