package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class LiteralExp extends Exp
{
    public LiteralExp(Integer pos) 
    {
        super(pos);

        internalValue.SetNil();
    }

    public LiteralExp(Integer pos, String stirngValue)
    {
        super(pos);

        internalValue.SetString(stirngValue);
    }

    public LiteralExp(Integer pos, Integer integer)
    {
        super(pos);

        internalValue.SetInteger(integer);
    }

    @Override
    public void getValue(TigerValue v) {
        v = internalValue; // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private TigerValue internalValue;
}