package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class IfElseExp extends Exp
{
    public IfElseExp(Integer pos, Exp condition, Exp executeIf) 
    {
        this(pos, condition, executeIf, null);
    }

    public IfElseExp(Integer pos, Exp condition, Exp executeIf, Exp executeElse) 
    {
        super(pos);

        this.condition = condition;
        this.executeIf = executeIf;
        this.executeElse = executeElse;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        if (condition.getType(c) != TigerSimpleType.TigerIntegerType)
        {
        	throw new TigerTypeException("if condition must be an integer.");
        }
        if (executeElse == null) 
        {
        	if (executeIf.getType(c) != null)
        	{
        		throw new TigerTypeException("must not return anything when we don't have an else");
        	}
        	return null;
        }
        else 
        {
        	if (executeIf.getType(c) != executeIf.getType(c))
        	{
        		throw new TigerTypeException("the return type of if should be the same as the return type of else");
        	}
        	return executeIf.getType(c);
        }
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "IfElseExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "condition: ");
        condition.print(c);
        print(c, "if body: ");
        executeIf.print(c);
        if (executeElse != null) {
            print(c, "else body: ");
            executeElse.print(c);
        }
        else 
        {
            print(c, "no else");
        }

        c.popIndentLevel();
    }

    private Exp condition;
    private Exp executeIf;
    private Exp executeElse; // could be null
}