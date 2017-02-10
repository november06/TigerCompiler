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
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return new TigerType(0);
    }

    @Override
    public String getTypeName() 
    {
        return "BreakExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "Break");
        c.popLevel();
    }
}