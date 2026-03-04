package com.example.naja.cli.commands;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;
import org.springframework.validation.annotation.Validated;

import com.example.naja.core.targets.Target;
import com.example.naja.interfaces.constraints.ValidFilePath;

import jakarta.validation.constraints.NotBlank;

/**
 * Root command for the Naja programming language command-line toolkit.
 */
@Validated
@Command(group = "Compiler commands", description = "Commands for compiling Naja programs.")
public class CompilationsCommand {
    @Command(command = "compile", description = "Compile a Naja program.", interactionMode = InteractionMode.NONINTERACTIVE)
    public void compile(
            @Option(description = "The source code to compile.", required = true) @NotBlank @ValidFilePath String path,
            @Option(longNames = "target", defaultValue = "JAVA", description = "The target language.") Target target) {
        System.out.println("Compiling " + path + " to " + target + "...");
    }
}
