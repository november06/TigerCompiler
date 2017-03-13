package tiger.parse;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;

import tiger.absyn.Exp;
import tiger.errormsg.ErrorMsg;
import tiger.others.Context;
import tiger.others.Print;

public class TypeCheckerTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
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
			System.out.println("------------------------------------------------------");
			e.getType(new Context());
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

}
