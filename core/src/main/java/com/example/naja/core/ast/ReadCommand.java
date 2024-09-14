package com.example.naja.core.ast;

import com.example.naja.core.types.Var;

public class ReadCommand extends Command {
    private Var var;

    public ReadCommand(Var var) {
        this.var = var;
    }

    public ReadCommand() {
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }
}
