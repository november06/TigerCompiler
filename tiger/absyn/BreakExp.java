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
        // TODO check inside a loop
        return  null;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
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