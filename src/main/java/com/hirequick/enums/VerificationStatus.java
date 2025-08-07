package com.hirequick.enums;

public enum VerificationStatus {
    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    FAILED("failed"),
    CANCELLED("cancelled"),
    COMPLETED("completed");

    private final String value;

    VerificationStatus(String value) {
        this.value = value;
    }  

    public String getValue() {
        return value;
    }

}
