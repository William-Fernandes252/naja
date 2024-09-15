package com.example.naja.restapi.services;

import com.example.naja.core.api.Compiler;
import com.example.naja.core.api.Result;
import com.example.naja.core.targets.JavaTargetGenerator;
import com.example.naja.core.targets.PythonTargetGenerator;
import com.example.naja.core.targets.TargetGenerator;
import com.example.naja.restapi.records.CompilationRequest;
import com.example.naja.restapi.records.CompilationResult;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NajaCompilerServiceImpl implements NajaCompilerServiceInterface {
    @Override
    public CompilationResult generateTarget(CompilationRequest compilationRequest) throws Throwable {
        String code = compilationRequest.getCode();
        TargetGenerator target = Objects.equals(compilationRequest.getTarget(), "python") ? new PythonTargetGenerator()
                : new JavaTargetGenerator();
        Compiler compiler = new Compiler(target);
        Result result = compiler.compile(code);
        if (result.error().isPresent()) {
            throw result.error().get();
        } else if (result.code().isPresent()) {
            return new CompilationResult(result.code().get(), compilationRequest.getTarget());
        }
        throw new IllegalStateException("Unexpected result");
    }
}
