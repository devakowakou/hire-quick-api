package com.hirequick.enums;

import lombok.Getter;

@Getter
public enum CompanyType {
    STARTUP("startup"),
    CORPORATION("corporation"),
    NON_PROFIT("non_profit"),
    GOVERNMENT("government"),
    AGENCY("agency"),
    CONSULTING("consulting"),
    OTHER("other");

    private final String value;

    CompanyType(String value) {
        this.value = value;
    }

}
