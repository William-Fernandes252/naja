package com.example.naja.core.targets;

import java.util.List;
import java.lang.reflect.Method;

import com.example.naja.core.exceptions.*;
import com.example.naja.core.ast.*;

public abstract class Target {
    /**
     * Generate the prelude code for the target language.
     * 
     * @return the prelude code.
     */
    public abstract String prelude(Program program);

    /**
     * Get the list of supported commands for the target language.
     * 
     * @return the list of supported commands.
     */
    public abstract List<Class<? extends Command>> getSupportedCommands();

    /**
     * Generate the code for the given program.
     * 
     * @param program the program to generate code for.
     * @return the code for the program.
     */
    public String generate(Program program) {
        StringBuilder builder = new StringBuilder();
        builder.append(prelude(program));
        builder.append(generate(program.getCommandList()));
        builder.append(epilogue());
        return builder.toString();
    }

    /**
     * Generate the code for the given command.
     * 
     * @param command the command to generate code for.
     * @return the code for the command.
     * @throws NajaTargetException if the command is not supported by the target
     *                             language.
     */
    public String generate(Command command) throws NajaTargetException {
        if (!getSupportedCommands().contains(command.getClass())) {
            throw new NajaTargetException("Command not supported by Java target");
        }

        try {
            Method method = this.getClass().getMethod("generate", command.getClass());
            return (String) method.invoke(this, command);
        } catch (NoSuchMethodException e) {
            throw new NajaTargetException("No method to handle command type: " + command.getClass(), e);
        } catch (Exception e) {
            throw new NajaTargetException("Error while processing command: " + command.getClass(), e);
        }
    }

    /**
     * Generate the code for a list of commands.
     * 
     * @param commandList the list of commands to generate code for.
     * @return the code for the list of commands.
     */
    public String generate(List<Command> commandList) throws NajaTargetException {
        StringBuilder builder = new StringBuilder();
        for (Command command : commandList) {
            builder.append(generate(command));
        }
        return builder.toString();
    }

    /**
     * Generate the epilogue code for the target language.
     * 
     * @return the epilogue code.
     */
    public String epilogue() {
        return "";
    }
}
