package com.e_commerceSystem.additional.converters;

import com.e_commerceSystem.additional.enums.ProductType;
import org.springframework.core.convert.converter.Converter;

import java.util.Locale;

public class ProductTypeStringToEnumConverter implements Converter<String, ProductType> {

    @Override
    public ProductType convert(String s) {
        return ProductType.valueOf(s.toUpperCase(Locale.ROOT));
    }
}
