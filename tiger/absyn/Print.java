package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;


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
            exp.print();
        }
    }

    private java.io.PrintStream destination;
}