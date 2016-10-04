/* --------------------------Usercode Section------------------------ */
package tiger.parse;
import tiger.errormsg.ErrorMsg;
import java_cup.runtime.*;

%%



/* -----------------Options and Declarations Section----------------- */

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
// %class Lexer  // to make the original program template happy
%char
%line
%column

/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup

%state COMMENT

%{   
    private static final boolean enableOutput = false;
    
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
        // return new java_cup.runtime.Symbol(kind, yychar, yychar+yylength(), value);
    }

    public Yylex(java.io.InputStream s, ErrorMsg e) {
        this(s);
        errorMsg = e;
    }

    private ErrorMsg errorMsg;
%}


%%
/* ------------------------Lexical Rules Section---------------------- */

// keywords
array      { return symbol(sym.ARRAY); }
break      { return symbol(sym.BREAK); }
do         { return symbol(sym.DO); }
else       { return symbol(sym.ELSE); }
end        { return symbol(sym.END); }
for        { return symbol(sym.FOR); }
function   { return symbol(sym.FUNCTION); }
if         { return symbol(sym.IF); }
in         { return symbol(sym.IN); }
let        { return symbol(sym.LET); }
nil        { return symbol(sym.NIL); }
of         { return symbol(sym.OF); }
then       { return symbol(sym.THEN); }
to         { return symbol(sym.TO); }
type       { return symbol(sym.TYPE); }
var        { return symbol(sym.VAR); }
while      { return symbol(sym.WHILE); }