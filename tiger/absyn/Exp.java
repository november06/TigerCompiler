package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class Exp 
{
    abstract void getValue(TigerValue v);

    abstract void getType(TigerType v);
}