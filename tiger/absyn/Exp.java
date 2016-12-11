package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class Exp 
{
    public Exp(Integer pos)
    {
        pos = pos;
    }

    abstract void getValue(TigerValue v);

    abstract void getType(TigerType v);

    abstract String getTypeName();

    public void print()
    {
        printPos();
        printType();
    }

    void printPos()
    {
        System.out.println("Exp position at: ");
        System.out.println(pos);
    }

    void printType()
    {
        System.out.println(getTypeName());
    }

    private Integer pos;
}