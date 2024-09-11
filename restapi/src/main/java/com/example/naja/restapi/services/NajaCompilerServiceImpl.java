package com.example.naja.restapi.services;

import java.io.IOException;
import java.io.InputStream;

import com.example.naja.core.lib.NajaGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Service;

import com.example.naja.core.lib.NajaGrammarLexer;
import com.example.naja.restapi.Enums.SupportedLanguages;

@Service
public class NajaCompilerServiceImpl implements NajaCompilerServiceInterface {
    @Override
    public String generateTarget(InputStream inputStream, SupportedLanguages language) {
        try {
            NajaGrammarLexer lexer = new NajaGrammarLexer(CharStreams.fromStream(inputStream));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            NajaGrammarParser parser = new NajaGrammarParser(tokenStream);
            System.out.println("UFABC Compiler");
            parser.programa();
            System.out.println("Compilation Successfully - Good Job");
            return "Works";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "dont work";
    }
}
