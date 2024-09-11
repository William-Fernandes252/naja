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

@members{
    private HashMap <String,Var> symbolTable = new HashMap<String, Var>();
    private ArrayList <Var> currentDec = new ArrayList<Var>();
    private Types currentType;
    private Types leftType = null , rightType = null;
    private Program program = new Program();
    private String strExpr = "";
    private String strAttr = "";
    private IfCommand currentIfCommand;
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
    private AbstractExpression topo = null;

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
    public void checkUnusedVariables() {
      for (Var var : symbolTable.values()) {
          if (!var.isUsed()) {
             throw new NajaSemanticException("Unused variable: " +var.getId());
        }
    }
}

}



// regras sintáticas
programa  : 'programa' ID 
                        {   
                            program.setName(_input.LT(-1).getText()); 
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
              checkUnusedVariables();
            }
          ;

declaravar  : 'declare' 
                {
                    currentDec.clear();
                }
                ID
                { 
                    currentDec.add(new Var(_input.LT(-1).getText()));
                }  
                (VIRG 
                ID 
                { 
                    currentDec.add(new Var(_input.LT(-1).getText()));
                } 
                )* DP ('number'
                {
                    currentType = Types.NUMBER;
                } 
                | 'text'
                 {
                    currentType = Types.TEXT;
                 } 
                )
                {
                    updateType();
                } 
                PV
            ;


comando     : cmdAttrib
            | cmdLeitura
            | cmdEscrita
            | cmdIf
            | cmdWhile
            ;
cmdAttrib   : ID 
                { 
                    if (!isDeclared(_input.LT(-1).getText())) {
                    throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
                  }
                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                  leftType = symbolTable.get(_input.LT(-1).getText()).getType();

                  AttCommand cmdAtt = new AttCommand();
                  cmdAtt.setVar(symbolTable.get(_input.LT(-1).getText()));
                  strAttr = "";

                }
               OP_AT expr 
               {
                  cmdAtt.setExpression(strAttr);
                  stack.peek().add(cmdAtt);
               }
               PV
               {
                    //System.out.println("left side expression type = " + leftType );
                    //System.out.println("right side expression type = " + rightType) ;
                    if(leftType.getValue() < rightType.getValue()){
                        throw new NajaSemanticException("Type Mismatch on Assigment");
                    }
                }
            ;

cmdLeitura  : 'leia' AP 
                      ID 
                        {   
                            if (!isDeclared(_input.LT(-1).getText())) {
                                throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
                            }
                            symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                            Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                            stack.peek().add(cmdRead);
                        } 
                      FP 
                      PV
            ;

cmdEscrita  :'escreva' AP 
                      (fator)
                      {
                        Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                                stack.peek().add(cmdWrite);

                      }  
                      FP PV
                        {
                            rightType = null;
                        }  
            ;           


cmdIf       : 'se'
                {   stack.push(new ArrayList<Command>());
                    strExpr = "";
                    currentIfCommand = new IfCommand();
                }
               AP
              expr
              OP_REL
               { 
                strExpr += _input.LT(-1).getText();
                strAttr += _input.LT(-1).getText();
               } 
              expr 
              FP
              { 
                currentIfCommand.setExpression(strExpr); 
              } 
              'entao'
              comando+
              {
                currentIfCommand.setTrueList(stack.pop());
              }
              ('senao'
              {
                stack.push(new ArrayList<Command>());
              } 
              comando+
              {
                currentIfCommand.setFalseList(stack.pop());
              }   
              )?
              'fimse'
                {
                    stack.peek().add(currentIfCommand);
                } 
            ;


cmdWhile    : 'enquanto' AP expr OP_REL expr FP 'faça' comando+ 'fimfaça'
            ;


expr      : termo {strExpr += _input.LT(-1).getText();
                  strAttr += _input.LT(-1).getText();
                }
           exprl 
          ;           

termo     : fator 
            termol
          ;
termol      : ((OP_MUL | OP_DIV)
                { 
                    strExpr += _input.LT(-1).getText();
                    strAttr += _input.LT(-1).getText();
                } 
               
                fator
                { 
                    strExpr += _input.LT(-1).getText();
                    strAttr += _input.LT(-1).getText();
                } 
                )*
            ;



exprl     : ( (OP_SUM |OP_SUB)
            { 
                strExpr += _input.LT(-1).getText();
                strAttr += _input.LT(-1).getText();
            }
            termo
             { 
                 strExpr += _input.LT(-1).getText();
                 strAttr += _input.LT(-1).getText();
             } 
   
            ) *
          ;

 fator    : ID
            { 
                if (!isDeclared(_input.LT(-1).getText())) {
                    throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
                  }
                  if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                    throw new NajaSemanticException("Variable: " +_input.LT(-1).getText() + " has no value assigned ");
                  }
                  if (rightType == null){
                    rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                }
                  else{
                    if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                    }
                  }
                  symbolTable.get(_input.LT(-1).getText()).setUsed(true); 
              }  
          | NUM 
            { 
                if (rightType == null) {
                  rightType = Types.NUMBER;
                  }
                  else{
                    if(rightType.getValue() < Types.NUMBER.getValue()){
                      rightType = Types.NUMBER;
                    }
                  }
                }
          | TEXTO
          { 
            if (rightType == null) {
                  rightType = Types.TEXT;
                  }
                  else{
                    if(rightType.getValue() < Types.TEXT.getValue()){
                      rightType = Types.TEXT;
                    }
                  }
                }
          ;         

// Regras léxicas


OP_SUM      :'+'
            ;

OP_SUB      :'-'
            ;

OP_MUL      :'*'
            ;

OP_DIV      :'/'
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

