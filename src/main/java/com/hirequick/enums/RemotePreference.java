package com.hirequick.enums;


import lombok.Getter;

@Getter
public enum RemotePreference {
    REMOTE("remote"),
    ONSITE("onsite"),
    HYBRID("hybrid");

    private final String value;
    RemotePreference(String value) {
        this.value = value;
    }
}
