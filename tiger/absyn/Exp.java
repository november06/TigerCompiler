package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class Exp 
{
    public Exp(Integer pos)
    {
        this.pos = pos;
    }

    abstract void getValue(TigerValue v);

    abstract void getType(TigerType v);

    abstract String getTypeName();

    public void print()
    {
        printPos();
        printType();
        System.out.println();
    }

    void printPos()
    {
        System.out.println("Exp position at: " + pos);
    }

    void printType()
    {
        System.out.println("Current type is: " + getTypeName());
    }

    private Integer pos;
}