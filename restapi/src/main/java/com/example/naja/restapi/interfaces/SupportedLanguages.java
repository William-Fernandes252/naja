package com.example.naja.restapi.interfaces;

import com.example.naja.restapi.validators.SupportedLanguagesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SupportedLanguagesValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedLanguages {
    String message() default "Only python or java";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
