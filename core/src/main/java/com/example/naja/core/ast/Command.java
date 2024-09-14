package com.example.naja.core.ast;

public abstract class Command {
    private String expression;

    public Command() {
    }

    public Command(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
