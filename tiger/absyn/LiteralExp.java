package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class LiteralExp extends Exp
{
    public LiteralExp(Integer pos) 
    {
        super(pos);
        internalValue = new TigerValue();
        internalValue.SetNil();
    }

    public LiteralExp(Integer pos, String stirngValue)
    {
        this(pos);

        internalValue.SetString(stirngValue);
    }

    public LiteralExp(Integer pos, Integer integerValue)
    {
        this(pos);
        
        internalValue.SetInteger(integerValue);
    }

    @Override
    public void getValue(TigerValue v) {
        v = internalValue; // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    @Override
    public String getTypeName() 
    {
        return "LiteralExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        if (internalValue.IsString())
        {
            print(c, "String Value is " + internalValue.GetStringValue());
        }
        else if (internalValue.IsInteger())
        {
            print(c, "Integer Value is " + internalValue.GetIntValue());
        }
        else 
        {
            print(c, "Nil Value");
        }
        c.popLevel();
    }

    private TigerValue internalValue;
}