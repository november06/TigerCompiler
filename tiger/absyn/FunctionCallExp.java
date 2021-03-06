package tiger.absyn;
import tiger.TigerValue;
import java.util.ArrayList;

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
        // verify
    	TigerType functionType = c.findIdentifierType(functionName);
    	if (!(functionType instanceof TigerFunctionType))
    	{
    		throw new TigerTypeException("Function type expected.");
    	}
    	ArrayList<TigerType> parameters = this.parameterList.getTigerTypeList();
    	if (!functionType.match(parameters))
    	{
    		throw new TigerTypeException("Unexpected function parameters");
    	}
        return functionType.getReturnType(); // could be null in case of a precedure
    }

    @Override
    public String getTypeName() 
    {
        return "FunctionCallExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "function name: " + functionName);
        print(c, "parameter list: ");
        parameterList.print(c);
        c.popIndentLevel();
    }

    private String functionName;
    private ListExp parameterList;
}