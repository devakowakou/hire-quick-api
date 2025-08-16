package com.hirequick.dtos;

public record RefreshTokenResponseDto(

        String accessToken,
        String tokenType,
        Integer expiresIn
) {
    public RefreshTokenResponseDto(
            String accessToken,
            String tokenType,
            Integer expiresIn
    ) {
        this.accessToken = accessToken;
        this.tokenType = "bearer";
        this.expiresIn = expiresIn;
    }
}
