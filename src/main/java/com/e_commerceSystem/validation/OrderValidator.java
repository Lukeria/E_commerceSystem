package com.e_commerceSystem.validation;

import com.e_commerceSystem.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {

    private final GlassValidator glassValidator;

    @Autowired
    public OrderValidator(GlassValidator glassValidator) {
        this.glassValidator = glassValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Order order = (Order) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productType", "message.notEmpty.calculator.productType");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "message.notEmpty.calculator.cost");

        if (order.getCost() != null && order.getCost() <= 0) {
            errors.rejectValue("cost", "message.notEmpty.calculator.cost");
        }

//        for (Glass glass : order.getGlassList()) {
//            ValidationUtils.invokeValidator(this.glassValidator, glass, errors);
//        }
    }
}
