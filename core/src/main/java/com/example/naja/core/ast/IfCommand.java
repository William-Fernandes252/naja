package com.example.naja.core.ast;

import java.util.List;

public class IfCommand extends Command{
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



    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("if ("+expression+") {\n");
        for (Command cmd: trueList){
            str.append(cmd.generateTarget());
        }
        str.append("}");
        if(falseList!=null){
            if(!falseList.isEmpty()){
                str.append("else {\n");
                for(Command cmd: falseList){
                    str.append(cmd.generateTarget());
                }

            }
        }
        return str.toString();
    }

}
