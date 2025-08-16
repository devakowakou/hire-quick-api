package com.hirequick.dtos;

import jakarta.validation.constraints.Size;

public record UserUpdateDto(
        @Size(min = 3, max = 100) String username,
        @Size(min = 10, max = 20) String phone,
        Boolean isActive
) {
}
