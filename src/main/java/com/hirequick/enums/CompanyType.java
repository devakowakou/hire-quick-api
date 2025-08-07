package com.hirequick.enums;

public enum CompanyType {
    STARTUP("startup"),
    CORPORATION("corporation"),
    NON_PROFIT("non_profit"),
    GOVERNMENT("government"),
    AGENCY("agency"),
    CONSULTING("consulting"),
    OTHER("other");

    private String value;

    CompanyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
