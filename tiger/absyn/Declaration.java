package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class Declaration extends Exp 
{
    public Declaration(Integer pos)
    {
        super(pos);
    }

    abstract void getValue(TigerValue v);

    abstract void getType(TigerType v);

    abstract String getTypeName();
}