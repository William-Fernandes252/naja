grammar NajaGrammar;

programa	: 'programa' 
               declaravar+
               expr 
               'fimprog'
			;

declaravar	: 'declare' 
               ID
               ( VIRG ID                
              		 
               )*	 
               DP 
               (
               'number' 
               |
               'text' 
               ) 

               
               PV
			;		

expr		:  termo exprl PV
			;

termo		: ID     
			| NUM    
			;

exprl		: ( OP termo ) *
			;	

OP			: '+' | '-' | '*' | '/' 
			;	

ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;

NUM			: [0-9]+ ('.' [0-9]+ )?
			;			

VIRG		: ','
			;

PV			: ';'
            ;			

DP			: ':'
		    ;

WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;