package com.example.naja.core.ast;

import com.example.naja.core.types.Types;
import com.example.naja.core.types.Var;

public class ReadCommand extends Command {
    private Var var;

    @Override
    public String generateTarget() {
        return var.getId() + " = " + ((var.getType() == Types.NUMBER) ? "_scNaja.nextInt();" : "_scNaja.nextLine();")
                + "\n";
    }

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
