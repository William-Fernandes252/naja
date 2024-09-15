package com.example.naja.interfaces.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.naja.interfaces.validators.FilePathValidator;

@Constraint(validatedBy = FilePathValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFilePath {
    String message() default "Invalid file path or file does not meet the requirements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Whether the file should be readable.
     */
    boolean readable() default true; // Check if the file should be readable

    /**
     * Whether the file should be writable.
     */
    boolean writable() default false;
}
