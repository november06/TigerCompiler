package tiger.others;
import tiger.TigerValue;

import tiger.absyn.Exp; 
import tiger.others.*;

public class Print
{
    public Print(java.io.PrintStream destination)
    {
    	this.destination = destination;
    }

    public void PrintExp(Exp exp)
    {
        if (exp == null) {
        	System.out.println("Error the input exp is null");
        }
        else {
            Context c = new Context(); 
            exp.print(c);
        }
    }

    private java.io.PrintStream destination;
}