package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class LiteralExp extends Exp
{
    public LiteralExp(Integer pos) 
    {
        super(pos);
        internalValue = new TigerValue();
        expType = TigerRecordType.TigerNilType;
        internalValue.SetNil(); // TODO Shane what record type this suppose to be ? be compatible to every record type
    }

    public LiteralExp(Integer pos, String stirngValue)
    {
        this(pos);

        expType = TigerSimpleType.TigerStringType;
        internalValue.SetString(stirngValue);
    }

    public LiteralExp(Integer pos, Integer integerValue)
    {
        this(pos);
        
        expType = TigerSimpleType.TigerIntegerType;
        internalValue.SetInteger(integerValue);
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
        c.pushIndentLevel();
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
        c.popIndentLevel();
    }

    private TigerValue internalValue;
    private TigerType expType;
}