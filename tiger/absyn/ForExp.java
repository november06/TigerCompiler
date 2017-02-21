package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class ForExp extends Exp
{
    public ForExp(Integer pos, String id, Exp eStart, Exp eEnd, Exp eAction) 
    {
        super(pos);

        idName = id;
        this.eStart = eStart;
        this.eEnd = eEnd;
        this.eAction = eAction;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }

    @Override
    public String getTypeName() 
    {
        return "ForExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "variable name" + idName);
        print(c, "start: ");
        eStart.print(c);
        print(c, "end: ");
        eEnd.print(c);
        print(c, "action: ");
        eAction.print(c);
        c.popLevel();
    }

    private String idName;
    private Exp eStart, eEnd;
    private Exp eAction;
}