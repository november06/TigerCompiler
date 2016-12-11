package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
    public void print()
    {
        super.print();
        if (internalValue.IsString())
        {
            System.out.print(internalValue.GetStringValue());
        }
        else if (internalValue.IsInteger())
        {
            System.out.print(internalValue.GetIntValue());
        }
        else 
        {
            System.out.print("Nil");
        }
        System.out.println();
    }

    private TigerValue internalValue;
}