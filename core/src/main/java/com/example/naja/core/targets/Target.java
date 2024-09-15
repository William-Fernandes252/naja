package com.example.naja.core.targets;

import java.util.Optional;

public enum Target {
    JAVA(new JavaTargetGenerator()), PYTHON(new PythonTargetGenerator());

    /**
     * The target generator for the target language.
     */
    private TargetGenerator generator;

    /**
     * Create a new target with the given generator.
     * 
     * @param generator
     */
    private Target(TargetGenerator generator) {
        this.generator = generator;
    }

    /**
     * Get the target generator for the target language.
     * 
     * @return the target generator.
     */
    public TargetGenerator getGenerator() {
        return generator;
    }

    /**
     * Get the target language from the given string.
     * 
     * @param target the target language.
     * @return the target language.
     */
    public static Optional<Target> fromString(String target) {
        for (Target t : Target.values()) {
            if (t.name().equalsIgnoreCase(target)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }
}
