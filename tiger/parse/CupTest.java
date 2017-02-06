package tiger.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import tiger.errormsg.ErrorMsg;
import tiger.absyn.*;
import tiger.others.Print;

public class CupTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0)
		{
			System.out.println("please pass the input file name in.");
			System.exit(2);
		}
		ErrorMsg errorMsg = new ErrorMsg(args[0]);
		InputStream inp = new FileInputStream(args[0]);
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
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

}
