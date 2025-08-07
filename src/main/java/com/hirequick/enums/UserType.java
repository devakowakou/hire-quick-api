package com.hirequick.enums;

public enum UserType {
    CANDIDATE("candidate"),
    RECRUITER("recruiter"),
    ADMIN("admin");

    private final String value;

    UserType(String value) {
        this.value = value;
    }  

    public String getValue() {
        return value;
    }

}
