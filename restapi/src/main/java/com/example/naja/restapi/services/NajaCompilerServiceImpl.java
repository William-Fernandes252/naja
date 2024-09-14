package com.example.naja.restapi.services;

import com.example.naja.core.lib.NajaGrammarParser;
import com.example.naja.restapi.records.CompilationRequest;
import com.example.naja.restapi.records.CompilationResult;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Service;

import com.example.naja.core.lib.NajaGrammarLexer;

@Service
public class NajaCompilerServiceImpl implements NajaCompilerServiceInterface {
    @Override
    public CompilationResult generateTarget(CompilationRequest compilationRequest) {
        NajaGrammarLexer lexer = new NajaGrammarLexer(CharStreams.fromString(compilationRequest.getCode()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        NajaGrammarParser parser = new NajaGrammarParser(tokenStream);
        parser.programa();
        System.out.println("Compilation Successfully - Good Job");
        return new CompilationResult("print('Hello world')", compilationRequest.getLang());
    }
}
