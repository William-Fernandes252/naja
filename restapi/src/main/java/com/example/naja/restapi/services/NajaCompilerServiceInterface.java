package com.example.naja.restapi.services;

import com.example.naja.restapi.records.CompilationRequest;
import com.example.naja.restapi.records.CompilationResult;

public interface NajaCompilerServiceInterface {
    CompilationResult generateTarget(CompilationRequest compilationRequest);
}
