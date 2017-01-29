package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class Type
{
    public Type(Integer pos)
    {
    	this.pos = pos;
    }

    // abstract String getName();

    // abstract void getValue(TigerValue v);

    // abstract void getType(TigerType v);

    private Integer pos;
}