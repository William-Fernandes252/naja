package com.example.naja.core.api;

import java.util.Optional;

import com.example.naja.core.ast.Program;

public record Result(boolean success, Optional<Program> program, Optional<String> code, Optional<Throwable> error) {
    public static Result error(Throwable error) {
        return new Result(false, Optional.empty(), Optional.empty(), Optional.of(error));
    }

    public static Result success(Program program, String code) {
        return new Result(true, Optional.of(program), Optional.of(code), Optional.empty());
    }
}
