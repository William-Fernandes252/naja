package com.example.naja.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

/**
 * Naja programming language command-line toolkit.
 * 
 * @see com.example.naja.cli.commands
 */
@SpringBootApplication
@CommandScan
public class CliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class, args);
    }
}
