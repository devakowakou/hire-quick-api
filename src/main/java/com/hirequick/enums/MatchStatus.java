package com.hirequick.enums;

public enum MatchStatus {
    PENDING("pending"),
    VIEWED("viewed"),
    INTERESTED("interested"),
    NOT_INTERESTED("not_interested"),
    CONTACTED("contacted"),
    EXPIRED("expired");

    private final String value;

    MatchStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
