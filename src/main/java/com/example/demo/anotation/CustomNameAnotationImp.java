package com.example.demo.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomNameAnotationImp implements ConstraintValidator<CustomName, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == "Yasin") {
            return false;
        }
        return false;
    }
}
