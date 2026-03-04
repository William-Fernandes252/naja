package com.example.naja.cli.advices;

import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;

public class CLIExceptionResolver implements CommandExceptionResolver {
    public CommandHandlingResult resolve(Exception ex) {
        return CommandHandlingResult.of(ex.getMessage() + '\n', 1);
    }

    public CommandHandlingResult resolve(ParameterValidationException ex) {
        return CommandHandlingResult.of(ex.getMessage() + '\n', 1);
    }
}
