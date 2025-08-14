package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum CompanySize {
    STARTUP("startup"),   // 1-10 employees
    SMALL("small"),       // 11-50 employees
    MEDIUM("medium"),     // 51-200 employees
    LARGE("large"),       // 201-1000 employees
    ENTERPRISE("enterprise"); // 1000+ employees

    private final String value;

    CompanySize(String value) {
        this.value = value;
    }

}
