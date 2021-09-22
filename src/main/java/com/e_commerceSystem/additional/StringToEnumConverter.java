package com.e_commerceSystem.additional;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, ComponentTypes> {
    @Override
    public ComponentTypes convert(String s) {
        return ComponentTypes.valueOfName(s);
    }
}
