/**
    Grammar for simple arithmetic operations (addition, subtration, multiplication and division)
    with grouping for natural numbers including zero, e.g. 2*(3+4)
*/
grammar Arithmetic;

// Parser
start : expr | <EOF> ;
expr : expr dotop expr      #DOTOP
        | expr dashop expr  #DASHOP
        | '(' expr ')'      #GROUP
        | NUMBER            #INTEGER
        ;
dashop : '+' | '-' ;
dotop : '*' | '/' ;


// Lexer
NUMBER : ('0' .. '9') ;
WS : [ \r\n\t] + -> skip ;