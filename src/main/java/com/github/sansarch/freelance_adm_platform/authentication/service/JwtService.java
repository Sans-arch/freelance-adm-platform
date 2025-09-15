package com.github.sansarch.freelance_adm_platform.authentication.service;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public final class JwtService {

    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public TokenInfo generateToken(String subject) {
        var now = Instant.now();
        var expiresIn = 300L; // 5 minutes

        var claims = JwtClaimsSet.builder()
            .issuer("freelance-adm-platform")
            .subject(subject)
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiresIn))
            .build();

        var jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new TokenInfo(jwt, expiresIn);
    }

    public record TokenInfo(String token, Long expiresIn) { }
}
