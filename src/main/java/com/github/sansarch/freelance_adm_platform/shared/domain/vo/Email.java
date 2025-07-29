package com.github.sansarch.freelance_adm_platform.shared.domain.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidEmailException;

import java.util.regex.Pattern;

public record Email(String value) implements ValueObject {
    private static final Pattern REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Email {
        if (value == null || value.isEmpty()) {
            throw new InvalidEmailException("Email cannot be null or empty");
        }
        if (!REGEX.matcher(value).matches()) {
            throw new InvalidEmailException("Invalid email format: " + value);
        }
    }
}
