package com.example.naja.interfaces.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

import com.example.naja.interfaces.validators.TargetValidator;

@Documented
@Constraint(validatedBy = TargetValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTarget {
    String message() default "Invalid target language.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
