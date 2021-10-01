package com.e_commerceSystem.additional.converters;

import com.e_commerceSystem.additional.enums.ComponentTypes;
import org.springframework.core.convert.converter.Converter;

public class ComponentTypeStringToEnumConverter implements Converter<String, ComponentTypes> {

    @Override
    public ComponentTypes convert(String s) {
        return ComponentTypes.valueOfName(s);
    }
}
