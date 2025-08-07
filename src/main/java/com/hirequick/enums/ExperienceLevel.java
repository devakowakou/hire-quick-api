package com.hirequick.enums;

public enum ExperienceLevel {
    ENTRY("entry"),
    JUNIOR("junior"),
    MID("mid"),
    SENIOR("senior"),
    LEAD("lead"),
    EXECUTIVE("executive");

    private final String value;

    ExperienceLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
