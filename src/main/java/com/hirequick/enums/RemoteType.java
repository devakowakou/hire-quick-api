package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum RemoteType {
    ONSITE("onsite"),
    REMOTE("remote"),
    HYBRID("hybrid");

    private final String value;

    RemoteType(String value) {
        this.value = value;
    }

}
