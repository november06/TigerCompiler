package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class BreakExp extends Exp
{
    public BreakExp(Integer pos)
    {
        super(pos);
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        if (c.getLoop() != 0)
        {
        	return null;
        }
        throw new TigerTypeException("Invalid break, not inside a loop");  // is tiger exception ok?
    }

    @Override
    public String getTypeName() 
    {
        return "BreakExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "Break");
        c.popIndentLevel();
    }
}