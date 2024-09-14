package com.example.naja.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.naja.core.api.Compiler;
import com.example.naja.core.api.Result;
import com.example.naja.core.targets.*;

public class App {
    public static void main(String[] args) {
        Target target = new JavaTarget();
        Result result = new Compiler(target).compile(new File("input.naja"));
        if (result.success()) {
            String code = result.code().get();
            try {
                FileWriter fileWriter = new FileWriter("output." + target.getExtension());
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(code);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result.error().ifPresent(Throwable::printStackTrace);
        }
    }
}
