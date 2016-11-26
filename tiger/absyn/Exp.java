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

    private Integer pos;
}