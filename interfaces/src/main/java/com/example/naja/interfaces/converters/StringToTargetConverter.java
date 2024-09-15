package com.example.naja.interfaces.converters;

import org.springframework.core.convert.converter.Converter;

import com.example.naja.core.targets.Target;

/**
 * A converter to convert a string to a target language.
 */
public class StringToTargetConverter implements Converter<String, Target> {
    @Override
    public Target convert(String source) {
        return Target.fromString(source)
                .orElseThrow(() -> new IllegalArgumentException("Unsupported target language: " + source));
    }
}
