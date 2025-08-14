package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum UserType {
    CANDIDATE("candidate"),
    RECRUITER("recruiter"),
    ADMIN("admin");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

}
