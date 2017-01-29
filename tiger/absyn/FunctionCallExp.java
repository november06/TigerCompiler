package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
    public void print()
    {
        super.print();
        System.out.print(functionName);
        parameterList.print();
        System.out.println();
    }

    private String functionName;
    private ListExp parameterList;
}