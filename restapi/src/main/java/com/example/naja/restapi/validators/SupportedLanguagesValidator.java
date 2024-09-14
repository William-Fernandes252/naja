package com.example.naja.restapi.validators;

import com.example.naja.restapi.interfaces.SupportedLanguages;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SupportedLanguagesValidator implements ConstraintValidator<SupportedLanguages, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equalsIgnoreCase("python") || value.equalsIgnoreCase("java");
    }
}
