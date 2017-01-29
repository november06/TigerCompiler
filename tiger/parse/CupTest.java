package tiger.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import tiger.errormsg.ErrorMsg;
import tiger.absyn.*;

public class CupTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "cuptest.txt";
		ErrorMsg errorMsg = new ErrorMsg(filename);
		InputStream inp = new FileInputStream(filename);
		Yylex lexer = new Yylex(inp, errorMsg);
		parser p = new parser(lexer);
		try {
			Exp e = null;
			if (tiger.absyn.Constants.enableDebug) {
			    e = (Exp)(p.debug_parse().value);
			}
			else {
				e = (Exp)(p.parse().value);
			}
			new Print(System.out).PrintExp(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
