package com.github.sansarch.freelance_adm_platform.domain.shared.vo;

import java.util.regex.Pattern;

public class Email implements ValueObject {

    private static final Pattern REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private final String value;

    public Email(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Email)) return false;
        Email other = (Email) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
