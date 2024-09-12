package com.example.naja.core.ast;

public class WriteCommand extends Command {
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public WriteCommand(String expression) {
        this.expression = expression;
    }
}
