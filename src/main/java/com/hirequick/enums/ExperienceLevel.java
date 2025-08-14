package com.hirequick.enums;

import lombok.Getter;

@Getter
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

}
