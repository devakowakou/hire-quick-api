package com.hirequick.dtos;

import com.hirequick.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.ZonedDateTime;

public record UserResponseDto(
        Long id,
        @NotBlank @Email  String email,
        @Size(min = 3, max = 50) String username,
        @NotNull  UserType userType,
        @Size(min = 10, max = 20) String phone,
        boolean isActive,
        boolean isVerified,
        boolean isSuperuser,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        ZonedDateTime lastLogin
) {}

