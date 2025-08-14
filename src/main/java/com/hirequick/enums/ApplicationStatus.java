package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum ApplicationStatus {
    DRAFT("draft"),
    SUBMITTED("submitted"),
    UNDER_REVIEW("under_review"),
    SCREENING("screening"),
    INTERVIEW_SCHEDULED("interview_scheduled"),
    INTERVIEWED("interviewed"),
    OFFER_EXTENDED("offer_extended"),
    OFFER_ACCEPTED("offer_accepted"),
    OFFER_DECLINED("offer_declined"),
    HIRED("hired"),
    REJECTED("rejected"),
    WITHDRAWN("withdrawn");

    private final String value;
    ApplicationStatus(String value) {
        this.value = value;
    }
}