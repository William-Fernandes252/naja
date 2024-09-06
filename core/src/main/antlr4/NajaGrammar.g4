grammar NajaGrammar;

@header{
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
    private String strExpr = "";
    private IfCommand currentIfCommand;
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();

    public void updateType(){
      for (Var v: currentDec){
        v.setType(currentType);
        symbolTable.put(v.getId(), v);
      }
    }


    public void exibirVar(){
        for (String id: symbolTable.keySet()){
            System.out.println(symbolTable.get(id));
        }
    }

    public boolean isDeclared(String id){
      return symbolTable.get(id) != null;
    }

    public Program getProgram(){
      return this.program;
    }

    private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
    private AbstractExpression topo = null;
    public double generateValue(){
        if (topo == null){
             topo = abeStack.pop();
        }
        return topo.evaluate();
    }

    public String generateJSON(){
         if (topo == null){
            topo = abeStack.pop();
        }
        return topo.toJson();

    }

}

// regras sintáticas
programa  : 'programa' ID { program.setName(_input.LT(-1).getText()); 
                            stack.push(new ArrayList<Command>());
                          }
            declaravar+
            'inicio'
            comando+
            'fim' 
            'fimprog'
            {
              program.setSymbolTable(symbolTable);
              program.setCommandList(stack.pop());
            }
          ;

comando     : cmdAttrib
            | cmdLeitura
            | cmdEscrita
            | cmdIf
            | cmdWhile
            ;
cmdWhile    : 'enquanto' AP expr OP_REL expr FP 'faça' comando+ 'fimfaça'
            ;
cmdIf       : 'se' { stack.push(new ArrayList<Command>());
                      strExpr = "";
                      currentIfCommand = new IfCommand();
                    }
               AP
              expr
              OP_REL { strExpr += _input.LT(-1).getText(); }
              expr 
              FP { currentIfCommand.setExpression(strExpr); }
              'entao'
              comando+{currentIfCommand.setTrueList(stack.pop());}
              ('senao' {stack.push(new ArrayList<Command>());}
              comando+ )?  {currentIfCommand.setFalseList(stack.pop());}
              'fimse' {stack.peek().add(currentIfCommand);}
            ;



cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
                  }
                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                  leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                }
               OP_AT expr PV
               {
                System.out.println("left side expression type = " + leftType );
                System.out.println("right side expression type = " + rightType) ;
                if(leftType.getValue() < rightType.getValue()){
                  throw new NajaSemanticException("Type Mismatch on Assigment");
                }
                }
            ;

cmdLeitura  : 'leia' AP 
                      ID
                      { if (!isDeclared(_input.LT(-1).getText())) {
                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
                      }
                      symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                      Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                      stack.peek().add(cmdRead);
                    } 
                      FP 
                      PV 
            ;


cmdEscrita  :'escreva' AP 
                      (termo) {Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                                stack.peek().add(cmdWrite);

                      } 
                      FP PV {rightType = null;}
            ;           

declaravar  : 'declare' {currentDec.clear();}
                ID { currentDec.add(new Var(_input.LT(-1).getText()));} 
                (VIRG 
                ID { currentDec.add(new Var(_input.LT(-1).getText()));} 
                )* DP ('number' {currentType = Types.NUMBER;}
                | 'text' {currentType = Types.TEXT;}
                ) 
                {updateType();}
                PV
            ;

expr      : termo{strExpr += _input.LT(-1).getText();
                }
           exprl 
          ;           

termo     : ID  { if (!isDeclared(_input.LT(-1).getText())) {
                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
                  }
                  if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                    throw new NajaSemanticException("Varible: " +_input.LT(-1).getText() + " has no value assigned ");
                  }
                  if (rightType == null){
                    rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                }
                  else{
                    if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                    }
                  }
              }
          | NUM { if (rightType == null) {
                  rightType = Types.NUMBER;
                  }
                  else{
                    if(rightType.getValue() < Types.NUMBER.getValue()){
                      rightType = Types.NUMBER;
                    }
                  }
                }
          | TEXTO{ if (rightType == null) {
                  rightType = Types.TEXT;
                  }
                  else{
                    if(rightType.getValue() < Types.TEXT.getValue()){
                      rightType = Types.TEXT;
                    }
                  }
                }
          ;

exprl     : ( OP { strExpr += _input.LT(-1).getText();} 
            termo { strExpr += _input.LT(-1).getText();} 
            ) *
          ;

// Regras léxicas
OP        : '+' | '-' | '*' | '/'
          ;

OP_AT     : ':='
          ;

OP_REL    : '>' | '<' | '>=' | '<=' | '<>' | '=='
          ;


ID        : [a-z] ([a-z] | [A-Z] | [0-9] ) *
          ;

NUM       : [0-9]+ ('.' [0-9]+ )?        // Numeros decimais
          ;

TEXTO     : '"' ([a-z] | [A-Z] | [0-9] | ',' | '.' |' ' | '-')* '"'
          ;

WS        : (' ' | '\n' | '\r' | '\t' ) -> skip
          ;

AP        : '('
          ;

FP        : ')'
          ;

VIRG        : ','
            ;
PV          : ';'
            ;
DP          : ':'
            ;


