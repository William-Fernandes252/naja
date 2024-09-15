package com.example.naja.interfaces.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

import com.example.naja.interfaces.constraints.ValidTarget;

/**
 * Validator for the {@link ValidTarget} constraint.
 */
public class TargetValidator implements ConstraintValidator<ValidTarget, String> {
    /**
     * The list of valid targets.
     */
    private final List<String> validTargets = Arrays.asList("java", "python");

    /**
     * Initializes the validator.
     * 
     * @param constraintAnnotation The constraint annotation.
     * @see ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validTargets.contains(value.toLowerCase());
    }
}