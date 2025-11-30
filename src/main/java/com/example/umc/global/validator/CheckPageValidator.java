package com.example.umc.global.validator;

import com.example.umc.global.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // null이거나 1 미만이면 유효하지 않음 -> 에러 발생
        return value != null && value >= 1;
    }
}
