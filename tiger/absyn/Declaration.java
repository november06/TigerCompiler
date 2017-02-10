package tiger.absyn;
import tiger.TigerValue;
import tiger.others.*;


public abstract class Declaration extends Exp 
{
    public Declaration(Integer pos)
    {
        super(pos);
    }

    abstract void getValue(TigerValue v);

    abstract TigerType getType(Context c);

    abstract String getTypeName();
}