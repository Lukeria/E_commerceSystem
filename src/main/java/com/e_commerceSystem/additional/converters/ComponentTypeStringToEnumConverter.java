package com.e_commerceSystem.additional.converters;

import com.e_commerceSystem.additional.enums.ComponentType;
import org.springframework.core.convert.converter.Converter;

public class ComponentTypeStringToEnumConverter implements Converter<String, ComponentType> {

    @Override
    public ComponentType convert(String s) {
        return ComponentType.valueOfName(s);
    }
}
