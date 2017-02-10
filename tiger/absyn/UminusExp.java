package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class UminusExp extends Exp
{
    public UminusExp(Integer pos, Exp e) 
    {
        super(pos);

        innerExp = e;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // verify
    	TigerType innerType = innerExp.getType(c);
    	if (!innerType.isInteger())
    	{
    		throw new TigerTypeException("Expected the parameter to be an integer!");
    	}
        return TigerType.TigerIntegerType; 
    }

    @Override
    public String getTypeName() 
    {
        return "UminusExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "-");
        print(c, "original value is ");
        innerExp.print(c);
        c.popLevel();
    }

    private Exp innerExp;
}