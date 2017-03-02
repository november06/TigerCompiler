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
        // TODO add id to the context, id is readonly
    	if (eStart.getType(c) != TigerSimpleType.TigerIntegerType 
    	 || eEnd.getType(c) != TigerSimpleType.TigerIntegerType) {
    	    throw new TigerTypeException("the bounds of for loops should be of integer type");
    	}
    	
    	if (eAction.getType(c) != null)
    	{
    		throw new TigerTypeException("the body of for loops should not return a value");
    	}
    	// TODO remove id from the context
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
        c.pushIndentLevel();
        super.print(c);
        print(c, "variable name" + idName);
        print(c, "start: ");
        eStart.print(c);
        print(c, "end: ");
        eEnd.print(c);
        print(c, "action: ");
        eAction.print(c);
        c.popIndentLevel();
    }

    private String idName;
    private Exp eStart, eEnd;
    private Exp eAction;
}