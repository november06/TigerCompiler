package tiger.absyn;
import tiger.TigerValue;
import tiger.others.*;


public abstract class Declaration extends Exp 
{
    public Declaration(Integer pos)
    {
        super(pos);
    }

    abstract TigerType getType(Context c) throws TigerTypeException ;

    abstract String getTypeName();
}