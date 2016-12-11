package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;


public class Print
{
    public Print(java.io.PrintStream destination)
    {
        destination = destination;
    }

    public void PrintExp(Exp exp)
    {
        exp.print();
    }

    private java.io.PrintStream destination;
}