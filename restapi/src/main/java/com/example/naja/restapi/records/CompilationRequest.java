package com.example.naja.restapi.records;

import com.example.naja.restapi.interfaces.SupportedLanguages;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CompilationRequest {
    @NotNull(message = "Source code cannot be null")
    @Size(min = 1, message = "Source code cannot be empty")
    private String code;

    @NotNull(message = "Source code cannot be null")
    @SupportedLanguages
    private String lang;
}
