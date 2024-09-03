package com.example.naja.core;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.example.naja.core.lib.NajaGrammarLexer;
import com.example.naja.core.lib.NajaGrammarParser;

public class Compiler {
    public static void main(String[] args) {
        try {
            NajaGrammarLexer lexer;
            NajaGrammarParser parser;
            String caminhoAtual = System.getProperty("user.dir");
            System.out.println("Caminho do diretório atual: " + caminhoAtual);
            lexer = new NajaGrammarLexer(CharStreams.fromFileName("input.in"));

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            parser = new NajaGrammarParser(tokenStream);
            System.out.println("Naja Compiler");
            parser.programa();
            System.out.println("Compilation Success!");
            parser.exibirVar();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            //e.printStackTrace();
        }
    }
    
}
