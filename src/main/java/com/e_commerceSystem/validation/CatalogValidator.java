package com.e_commerceSystem.validation;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CatalogValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Catalog.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Catalog catalog = (Catalog) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productType", "NotEmpty.calculator.productType");

        if(catalog.getProductType() == ProductType.GLASS){
            errors.rejectValue("productType", "NotEmpty.calculator.productType");
        }
    }
}
