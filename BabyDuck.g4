grammar BabyDuck;

// -------------------------
// LÉXICO (Tokens)
// -------------------------

PROGRAM     : 'program';
MAIN        : 'main';
END         : 'end';
VAR         : 'var';
INT         : 'int';
FLOAT       : 'float';
PRINT       : 'print';
WHILE       : 'while';
DO          : 'do';
IF          : 'if';
ELSE        : 'else';
VOID        : 'void';

ASSIGN      : '=';
PLUS        : '+';
MINUS       : '-';
TIMES       : '*';
DIVIDED     : '/';
SEMICOLON   : ';';
COLON       : ':';
COMMA       : ',';
LTHAN       : '<';
GTHAN       : '>';
LPAREN      : '(';
RPAREN      : ')';
LCURLY      : '{';
RCURLY      : '}';
NEQ         : '!=';

CTE_INT     : [0-9]+;
CTE_FLOAT   : [0-9]+ '.' [0-9]+;
CTE_STRING  : '"' (~["\\] | '\\' .)* '"';

ID          : [a-zA-Z_][a-zA-Z0-9_]*;
WS          : [ \t\r\n]+ -> skip;

// -------------------------
// SINTAXIS (Parser rules)
// -------------------------

programa         : PROGRAM ID SEMICOLON vars funcs MAIN body END;

vars             : (VAR idList COLON type SEMICOLON)*;
idList           : ID (COMMA ID)*;
type             : INT | FLOAT;

funcs            : ( VOID ID LPAREN paramList? RPAREN vars body SEMICOLON )*;
paramList        : ID COLON type ( COMMA ID COLON type )*; 

body             : LCURLY statement* RCURLY;
statement        : assign|print|condition|cycle|f_call;

assign           : ID ASSIGN expresion SEMICOLON;

print            : PRINT LPAREN ( expresion | CTE_STRING ) ( COMMA ( expresion | CTE_STRING ) )* RPAREN SEMICOLON;

condition        : IF LPAREN expresion RPAREN body (ELSE body)?;

cycle            : WHILE LPAREN expresion RPAREN DO body;

f_call           : ID LPAREN (expresion (COMMA expresion)*)? RPAREN SEMICOLON;

expresion        : exp ( oprel exp )?;

oprel            : NEQ | LTHAN | GTHAN;

exp              : termino ((PLUS|MINUS) termino)*;

termino          : factor ((TIMES|DIVIDED) factor)*;

factor           : LPAREN expresion RPAREN | (PLUS|MINUS)? (ID|cte) ;
cte              : CTE_INT|CTE_FLOAT;