package com.example.umc.global.annotation;

import com.example.umc.global.validator.CheckPageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class) // 검증기 연결
@Target({ElementType.PARAMETER, ElementType.FIELD}) // 파라미터에 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
        String message() default "페이지 번호는 1 이상이어야 합니다.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}
