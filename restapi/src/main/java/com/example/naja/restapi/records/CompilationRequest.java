package com.example.naja.restapi.records;

import com.example.naja.interfaces.constraints.ValidTarget;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CompilationRequest {
    @NotEmpty(message = "Source code cannot be empty")
    private String code;

    @NotEmpty(message = "Target language cannot be empty.")
    @ValidTarget
    private String target;
}
