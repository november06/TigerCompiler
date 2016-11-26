package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class FunctionCallExp extends Exp
{
    public FunctionCallExp(Integer pos, String functionName, Exp parameterList) 
    {
        super(pos);
        
        functionName = functionName;
        parameterList = parameterList;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private String functionName;
    private Exp parameterList;
}