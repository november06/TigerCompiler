package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class FunctionCallExp extends Exp
{
    public FunctionCallExp(Integer pos, String functionName, ListExp parameterList) 
    {
        super(pos);
        
        this.functionName = functionName;
        this.parameterList = parameterList;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return new TigerType(0);
    }

    @Override
    public String getTypeName() 
    {
        return "FunctionCallExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "function name: " + functionName);
        print(c, "parameter list: ");
        parameterList.print(c);
        c.popLevel();
    }

    private String functionName;
    private ListExp parameterList;
}