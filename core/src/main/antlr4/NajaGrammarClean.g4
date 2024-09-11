grammar NajaGrammarClean;

programa:
	'programa' ID declaravar+ 'inicio' comando+ 'fim' 'fimprog';

declaravar: 'declare' ID ( VIRG ID)* DP ( 'number' | 'text') PV;

comando: cmdAttrib | cmdLeitura | cmdEscrita | cmdIf | cmdWhile;
cmdAttrib: ID OP_AT expr PV;

cmdLeitura: 'leia' AP ID FP PV;

cmdEscrita: 'escreva' AP (fator) FP PV;

cmdIf:
	'se' AP expr OP_REL expr FP 'entao' comando+ (
		'senao' comando+
	)? 'fimse';

cmdWhile:
	'enquanto' AP expr OP_REL expr FP 'faça' comando+ 'fimfaça';

expr: termo exprl;

termo: fator termol;

termol: ( (OP_MUL | OP_DIV) fator)*;

exprl: ( (OP_SUM | OP_SUB) termo)*;

fator: ID | NUM | TEXTO;

// Regras léxicas

OP_SUM: '+';

OP_SUB: '-';

OP_MUL: '*';

OP_DIV: '/';

OP_AT: ':=';

OP_REL: '>' | '<' | '>=' | '<=' | '<>' | '==';

ID: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUM: [0-9]+ ('.' [0-9]+)?; // Numeros decimais

TEXTO: '"' ([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-')* '"';

WS: (' ' | '\n' | '\r' | '\t') -> skip;

AP: '(';

FP: ')';

VIRG: ',';

PV: ';';

DP: ':';