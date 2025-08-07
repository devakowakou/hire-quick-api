package com.hirequick.enums;

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

    public String getValue() {
        return value;
    }
}
