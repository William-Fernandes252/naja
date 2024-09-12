grammar NajaGrammar;

@header {
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import com.example.naja.core.types.*;
import com.example.naja.core.exceptions.*;
import com.example.naja.core.ast.*;
import com.example.naja.core.runtime.*;
}

@members {
private HashMap <String,Var> symbolTable = new HashMap<String, Var>();
private ArrayList <Var> currentDec = new ArrayList<Var>();
private Types currentType;
private Types leftType = null , rightType = null;
private Program program = new Program();
private String expressionStr = "";
private String assignmentStr = "";
private IfCommand currentIfCommand;
private WhileCommand currentWhileCommand;
private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
private AbstractExpression top = null;

public void updateTypes() {
    for (Var v: currentDec) {
        v.setType(currentType);
        symbolTable.put(v.getId(), v);
    }
}

public void showVariables() {
    for (String id: symbolTable.keySet()) {
        System.out.println(symbolTable.get(id));
    }
}

public boolean isDeclared(String id) {
    return symbolTable.get(id) != null;
}

public Program getProgram() {
    return this.program;
}

public double generateValue() {
    if (top == null) {
        top = abeStack.pop();
    }
    return top.evaluate();
}

public String generateJSON() {
    if (top == null) {
        top = abeStack.pop();
    }
    return top.toJson();
}

public void checkUnusedVariables() {
    for (Var var : symbolTable.values()) {
        if (!var.isUsed()) {
            throw new NajaSemanticException("Unused variable: " +var.getId());
        }
    }
}
}

// Syntactic rules
program:
	'program' ID {   
        program.setName(_input.LT(-1).getText()); 
        stack.push(new ArrayList<Command>());
    } declaration+ 'begin' command+ 'end' 'endprogram' {
        program.setSymbolTable(symbolTable);
        program.setCommandList(stack.pop());
        checkUnusedVariables();
    };

declaration:
	'declare' {
        currentDec.clear();
    } ID { 
        currentDec.add(new Var(_input.LT(-1).getText()));
    } (
		COMMA ID { 
            currentDec.add(new Var(_input.LT(-1).getText()));
        }
	)* COLON (
		'number' {
            currentType = Types.NUMBER;
        }
		| 'text' {
            currentType = Types.TEXT;
        }
	) {
        updateTypes();
    } SEMICOLON;

command: assignment | read | write | if | while;
assignment:
	ID { 
        String lastTokenText = _input.LT(-1).getText();
        if (!isDeclared(lastTokenText)) {
            throw new NajaSemanticException("Undeclared Variable: " + lastTokenText);
        }

        Var symbol = symbolTable.get(lastTokenText);
        symbol.setInitialized(true);

        leftType = symbolTable.get(_input.LT(-1).getText()).getType();

        AssignmentCommand assignment = new AssignmentCommand(null, symbol);

        assignmentStr = "";
    } ASSIGNMENT_OP expression {
        assignment.setExpression(assignmentStr);
        stack.peek().add(assignment);
    } SEMICOLON {
        if (leftType.getValue() < rightType.getValue()) {
            throw new NajaSemanticException("Type mismatch on assigment");
        }
    };

read:
	'read' LEFT_PAREN ID {   
        String lastTokenText = _input.LT(-1).getText();
        if (!isDeclared(lastTokenText)) {
            throw new NajaSemanticException("Undeclared Variable: " + lastTokenText);
        }

        Var symbol = symbolTable.get(lastTokenText);
        symbol.setInitialized(true);

        Command readCommand = new ReadCommand(symbol);
        stack.peek().add(readCommand);
    } RIGHT_PAREN SEMICOLON;

write:
	'write' LEFT_PAREN (factor) {
        Command writeCommand = new WriteCommand(_input.LT(-1).getText());
        stack.peek().add(writeCommand);
    } RIGHT_PAREN SEMICOLON {
        rightType = null;
    };

if:
	'if' {
        stack.push(new ArrayList<Command>());
        expressionStr = "";
        currentIfCommand = new IfCommand();
    } LEFT_PAREN expression COMPARISON_OP { 
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    } expression RIGHT_PAREN { 
        currentIfCommand.setExpression(expressionStr); 
    } 'then' command+ {
        currentIfCommand.setTrueList(stack.pop());
    } (
		'else' {
            stack.push(new ArrayList<Command>());
        } command+ {
            currentIfCommand.setFalseList(stack.pop());
        }
	)? 'endif' {
        stack.peek().add(currentIfCommand);
    };

while:
	'while' {
        stack.push(new ArrayList<Command>());
        expressionStr = "";
        currentWhileCommand = new WhileCommand();
    } LEFT_PAREN expression COMPARISON_OP {
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    } expression RIGHT_PAREN {
        currentWhileCommand.setExpression(expressionStr);
    } 'do' command+ {
        currentWhileCommand.setCommandList(stack.pop());
    } 'endwhile' {
        stack.peek().add(currentWhileCommand);
    };

expression:
	term {
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    } expressionl;

term: factor terml;
terml: (
		(MULTIPLICATION_OP | DIVISION_OP) { 
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    } factor { 
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    }
	)*;

expressionl: (
		(SUM_OP | SUBTRACTION_OP) { 
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    } term { 
        expressionStr += _input.LT(-1).getText();
        assignmentStr += _input.LT(-1).getText();
    }
	)*;

factor:
	ID { 
        String lastTokenText = _input.LT(-1).getText();
        if (!isDeclared(lastTokenText)) {
            throw new NajaSemanticException("Undeclared variable: " + lastTokenText);
        }

        Var symbol = symbolTable.get(lastTokenText);
        if (!symbol.isInitialized()) {
            throw new NajaSemanticException("Variable: " +lastTokenText + " has no value assigned ");
        }

        if (rightType == null){
            rightType = symbolTable.get(lastTokenText).getType();
        } else {
            if (symbolTable.get(lastTokenText).getType().getValue() > rightType.getValue()){
                rightType = symbolTable.get(lastTokenText).getType();
            }
        }
        
        symbol.setUsed(true); 
    }
	| NUM { 
        if (rightType == null) {
            rightType = Types.NUMBER;
        } else {
            if (rightType.getValue() < Types.NUMBER.getValue()) {
                rightType = Types.NUMBER;
            }
        }
    }
	| TEXT { 
        if (rightType == null) {
            rightType = Types.TEXT;
        } else {
            if (rightType.getValue() < Types.TEXT.getValue()) {
                rightType = Types.TEXT;
            }
        }
    };

// Lexical rules
SUM_OP: '+';

SUBTRACTION_OP: '-';

MULTIPLICATION_OP: '*';

DIVISION_OP: '/';

ASSIGNMENT_OP: ':=';

COMPARISON_OP: '>' | '<' | '>=' | '<=' | '<>' | '==';

ID: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUM: [0-9]+ ('.' [0-9]+)?;

TEXT: '"' ([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')* '"';

WHITE_SPACE: (' ' | '\n' | '\r' | '\t') -> skip;

LEFT_PAREN: '(';

RIGHT_PAREN: ')';

COMMA: ',';

SEMICOLON: ';';

COLON: ':';