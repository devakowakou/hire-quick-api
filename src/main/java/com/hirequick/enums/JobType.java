package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum JobType {
    FULL_TIME("full_time"),
    PART_TIME("part_time"),
    CONTRACT("contract"),
    INTERNSHIP("internship"),
    FREELANCE("freelance"),
    TEMPORARY("temporary");

    private final String value;

    JobType(String value) {
        this.value = value;
    }

}
