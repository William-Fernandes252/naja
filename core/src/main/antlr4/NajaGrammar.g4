grammar NajaGrammar;

@header{
    import java.util.ArrayList;
    import java.util.HashMap;
    import com.example.naja.types.*;
    import com.example.naja.core.exceptions.*;

}

@members {
    private HashMap <String,Var> symbolTable = new HashMap<String, Var>();
    private ArrayList <Var> currentDec = new ArrayList<Var>();
    private Types currentType;
    private Types leftType = null , rightType = null;

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
}

// regras sintáticas
programa  : 'programa'
            declaravar+
            'inicio'
            comando+
            'fim' 
            'fimprog'
          ;

comando     : cmdAttrib
            | cmdLeitura
            | cmdEscrita
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
                    } 
                      FP 
                      PV 
            ;


cmdEscrita  :'escreva' AP (termo) FP PV {rightType = null;}
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

expr      : termo exprl 
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

exprl     : ( OP termo ) *
          ;

// Regras léxicas
OP        : '+' | '-' | '*' | '/'
          ;

OP_AT     : ':='
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