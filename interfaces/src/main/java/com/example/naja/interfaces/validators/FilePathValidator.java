package com.example.naja.interfaces.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.File;

import com.example.naja.interfaces.constraints.ValidFilePath;

/**
 * Validator for the {@link ValidFilePath} constraint.
 */
public class FilePathValidator implements ConstraintValidator<ValidFilePath, String> {
    /**
     * Whether the file should be readable.
     */
    private boolean readable;

    /**
     * Whether the file should be writable.
     */
    private boolean writable;

    /**
     * Initializes the validator.
     *
     * @param constraintAnnotation The constraint annotation.
     */
    @Override
    public void initialize(ValidFilePath constraintAnnotation) {
        this.readable = constraintAnnotation.readable();
        this.writable = constraintAnnotation.writable();
    }

    /**
     * Validates the file path.
     *
     * @param path    The file path to validate.
     * @param context The constraint validator context.
     * @return {@code true} if the file path is valid, {@code false} otherwise.
     */
    @Override
    public boolean isValid(String path, ConstraintValidatorContext context) {
        if (path == null || path.trim().isEmpty()) {
            return false;
        }

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            return false;
        }

        if (readable && !file.canRead()) {
            return false;
        }

        if (writable && !file.canWrite()) {
            return false;
        }

        return true;
    }
}
