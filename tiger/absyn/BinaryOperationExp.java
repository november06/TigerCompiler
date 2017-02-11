package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class BinaryOperationExp extends Exp
{
    public static final Integer PLUS = 0;
    public static final Integer MINUS = 1;
    public static final Integer TIMES = 2;
    public static final Integer DIVIDE = 3;
    public static final Integer EQ = 4;
    public static final Integer NE = 5;
    public static final Integer LT = 6;
    public static final Integer LE = 7;
    public static final Integer GT = 8;
    public static final Integer GE = 9;
    public static final Integer AND = 10;
    public static final Integer OR = 11;

    public BinaryOperationExp(Integer pos, Exp e1, Integer op, Exp e2) 
    {
        super(pos);

        innerExpLeft = e1;
        innerExpRight = e2;

        operation = op;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
		TigerType left = innerExpLeft.getType(c);
		TigerType right = innerExpRight.getType(c);
    	
    	if (this.operation == PLUS
    	 || this.operation == MINUS
    	 || this.operation == TIMES
    	 || this.operation == DIVIDE)
    	{
    		// arithmetic
    		// require integer and return integer
    		if (!left.isInteger() || !right.isInteger()) {
    			throw new TigerTypeException("arithmetic paramaters should be both integer");
    		}
    		return TigerType.TigerIntegerType;
    	}
    	else if (this.operation == PLUS
    	      || this.operation == MINUS)
    	{
    		// Do two different type of records compares? I guess no
    		if (left.equals(right))
    		{
    			return TigerType.TigerIntegerType;
    		}
    		else 
    		{
    			throw new TigerTypeException("Two operators are of different types");
    		}
    	}
    	else if (this.operation == LT
    	      || this.operation == MINUS
    	      || this.operation == TIMES
    	      || this.operation == DIVIDE)
    	{
    		if ( (left.isInteger() && right.isInteger())
    		  || (left.isString() && right.isString()))
    		{
    		    return TigerType.TigerIntegerType;
    		}
    		throw new TigerTypeException("compare parameters should be both integer or both string");
    	}
    	else if (this.operation == AND
      	      || this.operation == OR)
    	{
    		// require integer and return integer
    		if (!left.isInteger() || !right.isInteger()) {
    			throw new TigerTypeException("logical operation paramaters should be both integer");
    		}
    		return TigerType.TigerIntegerType;
    	}
    	else {
    		throw new TigerTypeException("Internal status error, unexpected binary operator");
    	}
    }

    @Override
    public String getTypeName() 
    {
        return "BinaryOperationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);

        print(c, "left: ");
        innerExpLeft.print(c);

        String op = "PLUS";
        if (operation == BinaryOperationExp.MINUS)
        {
            op = "MINUS";
        }
        else if (operation == BinaryOperationExp.TIMES)
        {
            op = ("TIMES");
        }
        else if (operation == BinaryOperationExp.DIVIDE)
        {
            op = ("DIVIDE");
        }
        else if (operation == BinaryOperationExp.EQ)
        {
            op = ("EQ");
        }
        else if (operation == BinaryOperationExp.NE)
        {
            op = ("NE");
        }
        else if (operation == BinaryOperationExp.LT)
        {
            op = ("LT");
        }
        else if (operation == BinaryOperationExp.LE) 
        {
            op = ("LE");
        } 
        else if (operation == BinaryOperationExp.GT)
        {
            op = ("GT");
        } 
        else if (operation == BinaryOperationExp.GE)
        {
            op = ("GE");
        } 
        else if (operation == BinaryOperationExp.AND)
        {
            op = ("AND");
        } 
        else if (operation == BinaryOperationExp.OR)
        {
            op = ("OR");
        } 
        print(c, op);
        
        print(c, "right: ");
        innerExpRight.print(c);
        c.popLevel();
    }

    private Integer operation;
    private Exp innerExpLeft, innerExpRight;
}