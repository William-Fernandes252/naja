package com.example.naja.core.ast;

import java.util.List;

public class WhileCommand extends Command {
    private String expression;
    private List<Command> commandList;

    public WhileCommand() {
    }

    public WhileCommand(String expression, List<Command> commandList) {
        this.expression = expression;
        this.commandList = commandList;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("while(" + expression + ") {\n");
        for (Command cmd : commandList) {
            str.append(cmd.generateTarget());
        }
        str.append("}\n");
        return str.toString();
    }
}
