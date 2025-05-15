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

vars             : (VAR type ID listaIds SEMICOLON vars)?;
listaIds         : (COMMA ID)*;
type             : INT | FLOAT;

funcs            : (VOID ID SEMICOLON vars body funcs)?;

body             : LCURLY statement_list RCURLY;
statement_list   : (statement)*;

statement        : assign_stmt
                 | condition_stmt
                 | cycle_stmt
                 | print_stmt;

assign_stmt      : ID ASSIGN expresion SEMICOLON;

print_stmt       : PRINT LPAREN expresion print_list? RPAREN SEMICOLON;
print_list       : (COMMA expresion)*;

condition_stmt   : IF LPAREN expresion RPAREN body (ELSE body)?;

cycle_stmt       : WHILE LPAREN expresion RPAREN DO body;

expresion        : exp ( oprel exp )?;
oprel            : NEQ | LTHAN | GTHAN;

exp              : termino exp_tail;
exp_tail         : (PLUS termino exp_tail)? | (MINUS termino exp_tail)?;

termino          : factor termino_tail;
termino_tail     : (TIMES factor termino_tail)? | (DIVIDED factor termino_tail)?;

factor           : LPAREN expresion RPAREN | CTE_INT | CTE_FLOAT | CTE_STRING | ID;

