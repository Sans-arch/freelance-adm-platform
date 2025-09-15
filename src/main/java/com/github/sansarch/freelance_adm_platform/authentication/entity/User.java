package com.github.sansarch.freelance_adm_platform.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;


    @Column(unique = true)
    private String password;

    private Role role;

    public boolean isLoginCorrect(String passwordAttempt, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(passwordAttempt, this.getPassword());
    }
}
