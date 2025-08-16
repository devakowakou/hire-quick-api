package com.hirequick.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.hirequick.enums.UserType;


public record UserBaseDto(
        @NotBlank @Email String email,
        @Size(min = 2, max = 50) String username,
        @NotNull UserType userType,
        @Size(min = 10, max = 20) String phone
) {
    public UserBaseDto(String email, String username, UserType userType,String phone ){
        this.email = email;
        this.username = username;
        this.userType = (userType != null) ? userType : UserType.CANDIDATE;;
        this.phone = phone;

    }
}
