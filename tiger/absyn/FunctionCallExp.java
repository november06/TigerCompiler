package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class FunctionCallExp extends Exp
{
    public FunctionCallExp(Integer pos, String functionName, ListExp parameterList) 
    {
        super(pos);
        
        this.functionName = functionName;
        this.parameterList = parameterList;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
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