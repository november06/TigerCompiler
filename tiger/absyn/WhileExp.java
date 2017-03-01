package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class WhileExp extends Exp
{
    public WhileExp(Integer pos, Exp condition, Exp execute) 
    {
        super(pos);

        this.condition = condition;
        this.execute = execute;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        if (condition.getType(c) != TigerSimpleType.TigerIntegerType)
        {
        	throw new TigerTypeException("the condition of while should be of integer type.");
        }
        
        if (execute.getType(c) != null)
        {
        	throw new TigerTypeException("the while body should not return anything");
        }
        
        return null;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "WhileExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "condition is ");
        condition.print(c);
        print(c, "execute body is ");
        execute.print(c);
        c.popIndentLevel();
    }

    private Exp condition;
    private Exp execute;
}