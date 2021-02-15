package com.ay.validator;

import com.ay.param.ProductParam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductParamValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductParam.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "price", "price.empty");
        ProductParam productParam = (ProductParam) o;
        double price = productParam.getPrice().doubleValue();
        if (price < 0) {
            errors.rejectValue("price", null, "价格不能小于零");
        }
    }
}
