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
%state STRINGLITERAL
%state STRINGLITERALWHITESPACE

%{   
    private static final boolean enableOutput = false;
    
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline + 1, yycolumn + 1);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
        // return new java_cup.runtime.Symbol(kind, yychar, yychar+yylength(), value);
    }

    StringBuffer stringBuffer = new StringBuffer();

    int commentLevel = 0;

    // TODO for the following newline/err
    private void newline() {
        errorMsg.newline(yychar);
    }

    private void err(int pos, String s) {
	    errorMsg.error(pos, s);
    }

    private void err(String s) {
        err(yychar, s);
    }

    public Yylex(java.io.InputStream s, ErrorMsg e) {
        this(s);
        errorMsg = e;
    }

    private ErrorMsg errorMsg;
%}

%eofval{
{ 
	return symbol(sym.EOF, null);
}
%eofval}  

// DecIntegerLiteral = 0 | [1-9][0-9]*
DecIntegerLiteral = [0-9][0-9]*
Identifier = [a-zA-Z][a-zA-Z0-9_]*   //  Case is signiﬁcant. 
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]

%%
/* ------------------------Lexical Rules Section---------------------- */
<YYINITIAL> {
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

    {Identifier}        {
                            String msg = yytext();
                            if (tiger.absyn.Constants.enableDebug) {
                                System.err.println("parser read identifier: " +msg);
                            }
                            return symbol(sym.ID, msg); 
                        }
    {LineTerminator}	{ newline(); }
    {WhiteSpace}	    { /* do nothing */ }

    // should we check very long integer in there?
	{DecIntegerLiteral} {
                            String msg = yytext();
                            Integer value = Integer.parseInt(msg);
                            if (tiger.absyn.Constants.enableDebug) {
                                System.err.println("parser read integer: " +msg);
                            }
                            return symbol(sym.INT, value); 
                        }
	
	// [0-9]+   { return symbol(sym.INT, new String(yytext())); }

    \"          { yybegin(STRINGLITERAL); stringBuffer.setLength(0); }

    ","	        { return symbol(sym.COMMA, null); }
    ":"         { return symbol(sym.COLON, null); }
    ";"         { return symbol(sym.SEMICOLON, null); }
    "("         { return symbol(sym.LPAREN, null); }
    ")"         { return symbol(sym.RPAREN, null); }
    "["         { return symbol(sym.LBRACK, null); }
    "]"         { return symbol(sym.RBRACK, null); }
    "{"         { return symbol(sym.LBRACE, null); }
    "}"         { return symbol(sym.RBRACE, null); }
	"."	        { return symbol(sym.DOT, null); }
	"+"	        { return symbol(sym.PLUS, null); }
    "-"         { return symbol(sym.MINUS, null); }
    "*"         { return symbol(sym.TIMES, null); }
    "/"         { return symbol(sym.DIVIDE, null); }
    "="         { return symbol(sym.EQ, null); }
    "<>"        { return symbol(sym.NEQ, null); }
    "<"         { return symbol(sym.LT, null); }
    "<="        { return symbol(sym.LE, null); }
    ">"         { return symbol(sym.GT, null); }
    ">="        { return symbol(sym.GE, null); }
    "&"         { return symbol(sym.AND, null); }
    "|"         { return symbol(sym.OR, null); }
    ":="        { return symbol(sym.ASSIGN, null); }

    "/*"        { commentLevel = 1; yybegin(COMMENT); }

    [^]         { return symbol(sym.error, yytext()); }
}

<STRINGLITERAL> {
    \"                      { 
                                yybegin(YYINITIAL); 
                                String msg = stringBuffer.toString();
                                if (tiger.absyn.Constants.enableDebug) {
                                    System.err.println("parser read string literal: " +msg);
                                }
                                return symbol(sym.STRING, msg); 
                            }
    /* escape sequences */
    "\\t"                   { stringBuffer.append( '\t' ); } // tab
    "\\n"                   { stringBuffer.append( '\n' ); } // new line
    "\\\""                  { stringBuffer.append( '\"' ); } // double quote
    "\\\\"                  { stringBuffer.append( '\\' ); } // back slash
    \\\^[@A...Z\[\\\]\^_]   { stringBuffer.append(yytext().charAt(2) - '@');} 
    \\[0-9][0-9][0-9]       { char val = (char) Integer.parseInt(yytext().substring(1),10); stringBuffer.append( val );}
    \\                      { yybegin(STRINGLITERALWHITESPACE); }

    [^]                     { /*TODO error*/ }
}

<STRINGLITERALWHITESPACE> {
    {LineTerminator}	{ /* do nothing */ }
    {WhiteSpace}	    { /* do nothing */ }
    \\                  { yybegin(STRINGLITERAL); }
    [^]                 { /*TODO error*/ }
}

<COMMENT> {
    "/*"        { commentLevel++; } 
    "*/"        { if (--commentLevel == 0) yybegin(YYINITIAL); } 
    // TODO end of file and other error handling
	[^] { /* nothing*/ }
}