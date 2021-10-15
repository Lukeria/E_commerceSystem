package com.e_commerceSystem.validation;

import com.e_commerceSystem.entities.glass.Glass;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class GlassValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Glass.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Glass glass = (Glass) object;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "glassList[0].width", "message.notEmpty.calculator.glass.width");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "message.notEmpty.calculator.glass.height");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "message.notEmpty.calculator.glass.amount");

        if (glass.getWidth() != null && glass.getWidth() <= 0) {
            errors.rejectValue("glassList[0].width", "message.notEmpty.calculator.glass.width");
        }

        if (glass.getHeight() != null && glass.getHeight() <= 0) {
            errors.rejectValue("height", "message.notEmpty.calculator.glass.height");
        }

        if (glass.getAmount() != null && glass.getAmount() <= 0) {
            errors.rejectValue("amount", "message.notEmpty.calculator.glass.amount");
        }

    }
}
