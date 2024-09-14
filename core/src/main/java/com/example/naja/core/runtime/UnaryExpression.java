package com.example.naja.core.runtime;

public class UnaryExpression extends AbstractExpression {
    private double value;

    public UnaryExpression(double value) {
        this.value = value;
    }

    public UnaryExpression() {

    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toJson() {
        return "{ \"value\": " + this.value + "}";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
