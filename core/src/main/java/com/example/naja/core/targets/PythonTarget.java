package com.example.naja.core.targets;

import java.util.List;
import java.util.ArrayList;

import com.example.naja.core.ast.*;
import com.example.naja.core.types.Types;
import com.example.naja.core.types.Var;

public class PythonTarget extends Target {
    private static final List<Class<? extends Command>> supportedCommands = new ArrayList<Class<? extends Command>>();
    private static final int DEFAULT_INDENTATION_SIZE = 4;

    static {
        supportedCommands.add(AssignmentCommand.class);
        supportedCommands.add(ReadCommand.class);
        supportedCommands.add(WriteCommand.class);
        supportedCommands.add(IfCommand.class);
        supportedCommands.add(WhileCommand.class);
    }

    private int indentationLevel;
    private int indentationSize;

    public PythonTarget() {
        this(DEFAULT_INDENTATION_SIZE);
    }

    public PythonTarget(int indentationSize) {
        this.indentationSize = indentationSize;
        this.indentationLevel = 0;
    }

    @Override
    public List<Class<? extends Command>> getSupportedCommands() {
        return supportedCommands;
    }

    @Override
    public String head(Program program) {
        StringBuilder builder = new StringBuilder();
        builder.append("def main():\n");
        return builder.toString();
    }

    @Override
    public String body(Program program) {
        increaseIndentationLevel();
        String code = generate(program.getCommandList());
        resetIndentationLevel();
        return code;
    }

    @Override
    public String footer() {
        String checkNameCode = "if __name__ == \"__main__\":\n";
        increaseIndentationLevel();
        checkNameCode += getIdentation() + "main()";
        decreaseIndentationLevel();
        return checkNameCode;
    }

    public String generate(AssignmentCommand command) {
        StringBuilder str = new StringBuilder();
        str.append(command.getVar().getId());
        str.append("=" + command.getExpression().toString());
        return str.toString();
    }

    public String generate(ReadCommand command) {
        Var var = command.getVar();
        return var.getId() + "=" + ((var.getType() == Types.NUMBER) ? "int(input())" : "input()");
    }

    public String generate(WriteCommand command) {
        return "print(" + command.getExpression().toString() + ")";
    }

    public String generate(IfCommand command) {
        StringBuilder builder = new StringBuilder();
        builder.append("if " + command.getExpression().toString() + ":\n");
        increaseIndentationLevel();
        builder.append(generate(command.getTrueList()));
        decreaseIndentationLevel();
        if (command.getFalseList() != null && !command.getFalseList().isEmpty()) {
            builder.append(getIdentation() + "else:\n");
            increaseIndentationLevel();
            builder.append(generate(command.getFalseList()));
            decreaseIndentationLevel();
        }
        return builder.toString();
    }

    public String generate(WhileCommand command) {
        StringBuilder builder = new StringBuilder();
        builder.append("while " + command.getExpression().toString() + ":\n");
        increaseIndentationLevel();
        builder.append(generate(command.getCommandList()));
        decreaseIndentationLevel();
        return builder.toString();
    }

    public String generate(List<Command> commandList) {
        StringBuilder builder = new StringBuilder();
        for (Command command : commandList) {
            builder.append(getIdentation() + generate(command) + "\n");
        }
        return builder.toString();
    }

    private void increaseIndentationLevel() {
        this.indentationLevel++;
    }

    private void decreaseIndentationLevel() {
        this.indentationLevel--;
    }

    private void resetIndentationLevel() {
        this.indentationLevel = 0;
    }

    private String getIdentation() {
        return " ".repeat(indentationLevel * indentationSize);
    }
}
