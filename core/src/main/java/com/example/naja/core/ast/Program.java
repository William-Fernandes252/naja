package com.example.naja.core.ast;

import java.util.HashMap;
import java.util.List;

import com.example.naja.core.types.Var;

public class Program {
    private String name;
    private HashMap<String, Var> symbolTable;
    private List<Command> commandList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Var> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(HashMap<String, Var> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
}
