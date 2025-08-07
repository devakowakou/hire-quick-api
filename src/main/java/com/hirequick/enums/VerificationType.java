package com.hirequick.enums;

public enum VerificationType {
    IDENTITY("identity"),
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

    public String getValue() {
        return value;
    }    
}
