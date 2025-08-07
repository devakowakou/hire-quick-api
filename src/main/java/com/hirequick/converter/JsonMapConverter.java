package com.hirequick.converter;

import jakarta.persistence.Converter;
import java.util.Map;

@Converter
public class JsonMapConverter extends GenericJsonConverter<Map<String, Object>> {
    @SuppressWarnings("unchecked")
    public JsonMapConverter() {
        super((Class<Map<String, Object>>) (Class<?>) Map.class);
    }
}
