package com.example.naja.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.example.naja.core.ast.Program;
import com.example.naja.core.lib.NajaGrammarLexer;
import com.example.naja.core.lib.NajaGrammarParser;

public class MainClass {
    public static void main(String[] args) {
        try {
            NajaGrammarLexer lexer;
            NajaGrammarParser parser;
            // String caminhoAtual = System.getProperty("user.dir");
            // System.out.println("Caminho do diretório atual: " + caminhoAtual);

            // Criar o analisador léxico
            lexer = new NajaGrammarLexer(CharStreams.fromFileName("program.in"));

            // a partir do analisador léxico , obeter o fluxo de tokens
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // a partir do fluxo de tokens criar o parser
            parser = new NajaGrammarParser(tokenStream);

            // chamar o parser
            System.out.println("Naja Compiler");
            parser.programa();
            System.out.println("Compilation Success!");

            // geração de código
            Program program = parser.getProgram();

            try {
                File f = new File(program.getName() + ".java");
                FileWriter fr = new FileWriter(f);
                PrintWriter pr = new PrintWriter(fr);
                pr.println(program.generateTarget());
                pr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(program.generateTarget());

        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            // ex.printStackTrace();
        }
    }
}
