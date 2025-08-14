package com.hirequick.enums;

import lombok.Getter;

@Getter
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

}
