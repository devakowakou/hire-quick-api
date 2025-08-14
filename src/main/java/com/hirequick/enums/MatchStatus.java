package com.hirequick.enums;

import lombok.Getter;

@Getter
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

}
