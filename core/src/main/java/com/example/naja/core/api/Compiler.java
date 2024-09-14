package com.example.naja.core.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CommonTokenStream;

import com.example.naja.core.lib.*;
import com.example.naja.core.targets.Target;

public class Compiler {
    private Target target;
    private NajaGrammarLexer lexer;
    private NajaGrammarParser parser;

    public Compiler(Target target) {
        setTarget(target);
    }

    public Result compile(String source) {
        return compileWithLexerSetup(() -> setLexer(source));
    }

    public Result compile(InputStream source) {
        return compileWithLexerSetup(() -> setLexer(source));
    }

    public Result compile(File source) {
        return compileWithLexerSetup(() -> setLexer(source));
    }

    private Result compileWithLexerSetup(LexerSetup lexerSetup) {
        try {
            lexerSetup.setup();
        } catch (IOException e) {
            return Result.error(e);
        }
        return compile();
    }

    private Result compile() {
        CommonTokenStream tokenStream = new CommonTokenStream(getLexer());
        setParser(new NajaGrammarParser(tokenStream));
        getParser().program();
        return Result.success(getParser().getProgram(), getTarget().generate(getParser().getProgram()));
    }

    public Target getTarget() {
        return target;
    }

    private void setTarget(Target target) {
        this.target = target;
    }

    private NajaGrammarLexer getLexer() {
        return lexer;
    }

    private void setLexer(NajaGrammarLexer lexer) {
        this.lexer = lexer;
    }

    private void setLexer(String source) throws IOException {
        setLexer(new NajaGrammarLexer(org.antlr.v4.runtime.CharStreams.fromString(source)));
    }

    private void setLexer(InputStream source) throws IOException {
        setLexer(new NajaGrammarLexer(org.antlr.v4.runtime.CharStreams.fromStream(source)));
    }

    private void setLexer(File file) throws IOException {
        setLexer(new NajaGrammarLexer(org.antlr.v4.runtime.CharStreams.fromFileName(file.getAbsolutePath())));
    }

    private NajaGrammarParser getParser() {
        return parser;
    }

    private void setParser(NajaGrammarParser parser) {
        this.parser = parser;
    }

    @FunctionalInterface
    private interface LexerSetup {
        void setup() throws IOException;
    }
}