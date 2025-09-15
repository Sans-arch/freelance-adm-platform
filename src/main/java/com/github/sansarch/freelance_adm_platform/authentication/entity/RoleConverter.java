package com.github.sansarch.freelance_adm_platform.authentication.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.getCode();
    }

    @Override
    public Role convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Role.values())
            .filter(r -> r.getCode() == code)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
