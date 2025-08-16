package com.hirequick.dtos;

import com.hirequick.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateDto(
        @NotBlank @Email String email,
        @Size(min = 3, max = 50) String username,
        @NotNull UserType userType,
        @Size(min = 10, max = 20) String phone,
        @NotBlank @Size(min = 8) String password,
        @NotBlank String confirmPassword
) {
    public UserCreateDto {
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }
}

