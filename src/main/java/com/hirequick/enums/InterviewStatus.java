package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum InterviewStatus {
    SCHEDULED("scheduled"),
    CONFIRMED("confirmed"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    RESCHEDULED("rescheduled"),
    NO_SHOW("no_show");

    private final String value;

    InterviewStatus(String value) {
        this.value = value;
    }

}