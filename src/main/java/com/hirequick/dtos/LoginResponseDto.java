package com.hirequick.dtos;

public record LoginResponseDto(
        String accessToken,
        String refreshToken,
        String tokenType,
        Integer expiresIn,
        UserResponseDto user
) {

    public LoginResponseDto(
            String accessToken,
            String refreshToken,
            String tokenType,
            Integer expiresIn,
            UserResponseDto user
    ) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = "bearer";
        this.expiresIn = expiresIn;
        this.user = user;
    }
}

