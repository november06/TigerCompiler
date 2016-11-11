package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class LiteralExp extends Exp
{
    public LiteralExp(Integer pos) 
    {
        internalValue.SetNil();
    }

    public LiteralExp(Integer pos, String stirngValue)
    {
        internalValue.SetString(stirngValue);
    }

    public LiteralExp(Integer pos, Integer integer)
    {
        internalValue.SetInteger(integer);
    }

    @Override
    public void getValue(TigerValue v) {
        v = internalValue; // TODO
    }

    @Override
    public void getType(TigerType v) {

    }

    private TigerValue internalValue;
}