package com.example.naja.core.ast;

import java.util.List;

public class IfCommand extends Command {
    private String expression;
    private List<Command> trueList;
    private List<Command> falseList;

    public IfCommand() {
    }

    public IfCommand(String expression, List<Command> trueList, List<Command> falseList) {
        this.expression = expression;
        this.trueList = trueList;
        this.falseList = falseList;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<Command> getTrueList() {
        return trueList;
    }

    public void setTrueList(List<Command> trueList) {
        this.trueList = trueList;
    }

    public List<Command> getFalseList() {
        return falseList;
    }

    public void setFalseList(List<Command> falseList) {
        this.falseList = falseList;
    }
}
