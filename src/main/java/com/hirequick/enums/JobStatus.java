package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum JobStatus {
    DRAFT("draft"),
    ACTIVE("active"),
    PAUSED("paused"),
    CLOSED("closed"),
    EXPIRED("expired");

    private final String value;

    JobStatus(String value) {
        this.value = value;
    }

}
