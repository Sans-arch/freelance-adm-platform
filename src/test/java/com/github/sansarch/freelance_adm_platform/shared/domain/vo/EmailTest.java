package com.github.sansarch.freelance_adm_platform.shared.domain.vo;

import com.github.sansarch.freelance_adm_platform.shared.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateNewValidEmail() {
        String input = "john.doe@john.com";
        var result = new Email(input);

        assertNotNull(result);
        assertEquals(input, result.value());
    }

    @Test
    void shouldThrowInvalidEmailExceptionWhenNull() {
        assertThrows(InvalidEmailException.class, () -> new Email(null));
    }

    @Test
    void shouldThrowInvalidEmailExceptionWhenBlank() {
        assertThrows(InvalidEmailException.class, () -> new Email(""));
    }

    @Test
    void shouldThrowInvalidEmailExceptionWhenInvalidFormat() {
        assertThrows(InvalidEmailException.class, () -> new Email("jack"));
        assertThrows(InvalidEmailException.class, () -> new Email("jack@.com"));
        assertThrows(InvalidEmailException.class, () -> new Email("@ak"));
    }
}