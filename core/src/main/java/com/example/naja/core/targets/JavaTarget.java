package com.example.naja.core.targets;

import java.util.List;
import java.util.ArrayList;

import com.example.naja.core.ast.*;
import com.example.naja.core.types.Types;
import com.example.naja.core.types.Var;
import com.example.naja.core.utils.StringUtils;

public class JavaTarget extends Target {
    private static final List<Class<? extends Command>> supportedCommands = new ArrayList<Class<? extends Command>>();
    private static final String EXTENSION = "java";

    static {
        supportedCommands.add(AssignmentCommand.class);
        supportedCommands.add(ReadCommand.class);
        supportedCommands.add(WriteCommand.class);
        supportedCommands.add(IfCommand.class);
        supportedCommands.add(WhileCommand.class);
    }

    @Override
    public List<Class<? extends Command>> getSupportedCommands() {
        return supportedCommands;
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public String head(Program program) {
        StringBuilder builder = new StringBuilder();
        builder.append("import java.util.Scanner;\n");
        builder.append("public class " + StringUtils.toCapitalized(program.getName()) + "{");
        builder.append("public static void main(String args[]){");
        builder.append("Scanner _scNaja=new Scanner(System.in);");
        return builder.toString();
    }

    @Override
    public String footer() {
        return "}}";
    }

    public String generate(AssignmentCommand command) {
        StringBuilder str = new StringBuilder();
        str.append(command.getVar().getId());
        str.append("=" + command.getExpression().toString() + ";");
        return str.toString();
    }

    public String generate(ReadCommand command) {
        Var var = command.getVar();
        return var.getId() + "=" + ((var.getType() == Types.NUMBER) ? "_scNaja.nextInt();" : "_scNaja.nextLine();");
    }

    public String generate(WriteCommand command) {
        return "System.out.println(" + command.getExpression().toString() + ");";
    }

    public String generate(IfCommand command) {
        StringBuilder builder = new StringBuilder();
        builder.append("if(" + command.getExpression().toString() + "){");
        for (Command trueCommand : command.getTrueList()) {
            builder.append(generate(trueCommand));
        }
        builder.append("}");
        if (command.getFalseList() != null && !command.getFalseList().isEmpty()) {
            builder.append("else {");
            for (Command falseCommand : command.getFalseList()) {
                builder.append(generate(falseCommand));
            }
        }
        return builder.toString();
    }

    public String generate(WhileCommand command) {
        StringBuilder builder = new StringBuilder();
        builder.append("while(" + command.getExpression().toString() + "){");
        builder.append(generate(command.getCommandList()));
        builder.append("}");
        return builder.toString();
    }
}
