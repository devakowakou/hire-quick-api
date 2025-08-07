package com.hirequick.enums;

public enum RemoteType {
    ONSITE("onsite"),
    REMOTE("remote"),
    HYBRID("hybrid");

    private final String value;

    RemoteType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
