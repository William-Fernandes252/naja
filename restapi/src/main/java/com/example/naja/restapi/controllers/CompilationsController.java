package com.example.naja.restapi.controllers;

import com.example.naja.restapi.records.CompilationRequest;
import com.example.naja.restapi.records.CompilationResult;
import com.example.naja.restapi.services.NajaCompilerServiceInterface;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompilationsController {
    private final NajaCompilerServiceInterface najaCompilerService;

    private CompilationsController(NajaCompilerServiceInterface najaCompilerService) {
        this.najaCompilerService = najaCompilerService;
    }

    @PostMapping("/compile")
    public CompilationResult compile(@RequestBody @Valid CompilationRequest compilationRequest) throws Throwable {
        return this.najaCompilerService.generateTarget(compilationRequest);
    }
}
