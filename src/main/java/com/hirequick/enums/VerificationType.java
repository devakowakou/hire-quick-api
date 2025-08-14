package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum VerificationType {
    INDENTITY("identity"),
    EMPLOYMENT("employment"),
    EDUCATION("education"),
    CRIMINAL("criminal"),
    CREDIT("credit"),
    REFERENCE("reference"),
    PROFESSIONAL_LICENSE("professional_license"),
    DRUG_TEST("drug_test");

    private final String value;
    VerificationType(String value) {
        this.value = value;
    }
}