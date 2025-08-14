package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum InterviewType {
    PHONE("phone"),
    VIDEO("video"),
    IN_PERSON("in_person"),
    TECHNICAL("technical"),
    BEHAVIORAL("behavioral"),
    FINAL("final"),
    PANEL("panel");

    private final String value;

    InterviewType(String value) {
        this.value = value;
    }

}