package com.example.naja.core.ast;

import com.example.naja.core.types.Var;

public class AssignmentCommand extends Command {
    private String expression;
    private Var var;

    public AssignmentCommand() {
    }

    public AssignmentCommand(String expression, Var var) {
        this.expression = expression;
        this.var = var;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }

    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append(var.getId() + " ");
        str.append(" = " + expression + ";\n");
        return str.toString();
    }
}
