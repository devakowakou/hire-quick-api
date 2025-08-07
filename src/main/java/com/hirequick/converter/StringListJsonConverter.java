package com.hirequick.converter;

import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class StringListJsonConverter extends GenericJsonConverter<List<String>> {
    @SuppressWarnings("unchecked")
    public StringListJsonConverter() {
        super((Class<List<String>>) (Class<?>) List.class);
    }
}
