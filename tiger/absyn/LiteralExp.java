package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class LiteralExp extends Exp
{
    public LiteralExp(Integer pos) 
    {
        super(pos);
        internalValue = new TigerValue();
        expType = new TigerType(TigerType.simple);
        expType.simpleTypeName = TigerType.TigerSimpleTypeNilName;
        internalValue.SetNil();
    }

    public LiteralExp(Integer pos, String stirngValue)
    {
        this(pos);

        expType.simpleTypeName = TigerType.TigerSimpleTypeStringName;
        internalValue.SetString(stirngValue);
    }

    public LiteralExp(Integer pos, Integer integerValue)
    {
        this(pos);
        
        expType.simpleTypeName = TigerType.TigerSimpleTypeIntegerName;
        internalValue.SetInteger(integerValue);
    }

    @Override
    public void getValue(TigerValue v) {
        v = internalValue; // TODO
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        return expType;
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
    private TigerType expType;
}