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

    private void newline() { // TODO
        errorMsg.newline(yychar);
    }

    private void err(int pos, String s) { // TODO
	    errorMsg.error(pos, s);
    }

    private void err(String s) { // TODO
        err(yychar, s);
    }

    public Yylex(java.io.InputStream s, ErrorMsg e) {
        this(s);
        errorMsg = e;
    }

    private ErrorMsg errorMsg;
%}

%eofval{  // TODO
{ 
	return symbol(sym.EOF, null);
}
%eofval}  

DecIntegerLiteral = 0 | [1-9][0-9]*
Identifier = [a-zA-Z][a-zA-Z0-9_]*   //  Case is signiﬁcant. 
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]

%%
/* ------------------------Lexical Rules Section---------------------- */
<YYINITIAL> {
    // keywords
    of         { return symbol(sym.OF); }


    {Identifier}        {
                            String msg = yytext();
                            System.err.println("shane debug");
                            System.err.println(msg);
                            return symbol(sym.ID, msg); 
                        }
    {LineTerminator}	{ newline(); }
    {WhiteSpace}	    { /* do nothing */ }

    // should we check very long integer in there?
	{DecIntegerLiteral} {
                            Integer value = Integer.parseInt(yytext());
                            return symbol(sym.INT, value); 
                        }
	
	// or not? // TODO
	// [0-9]+   { return symbol(sym.INT, new String(yytext())); }

    \"          { yybegin(STRINGLITERAL); stringBuffer.setLength(0); }

    "["         { return symbol(sym.LBRACK, null); }
    "]"         { return symbol(sym.RBRACK, null); }
	"."	        { return symbol(sym.DOT, null); }

    "/*"        { commentLevel = 1; yybegin(COMMENT); }

    [^]         { return symbol(sym.error, yytext()); }
}

<STRINGLITERAL> {
    \"      { yybegin(YYINITIAL); return symbol(sym.STRING, stringBuffer.toString()); }
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