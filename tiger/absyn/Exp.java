package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public abstract class Exp 
{
    public Exp(Integer pos)
    {
    	if (Constants.enableDebug)
    	{
    		System.out.println("In the ctor of " + getTypeName());
    	}
    	
        this.pos = pos;
    }

    /// get the type of the expression. 
    /// if it's tiger type nil, return a tiger type with that value
    /// if there should be no type for this expression, return null
    /// if the type specified is not available exception: 
    ///     variable can't find 
    ///     type is not available (does it matter? we could look for the type later when all the definitions are available)
    ///     ?
    abstract TigerType getType(Context c) throws TigerTypeException;

    abstract String getTypeName();
    
    public int getCompileTimeIntValue(Context c) throws TigerTypeException
    {
    	if (this.getType(c) != TigerSimpleType.TigerIntegerType) 
    	{
    		throw new TigerTypeException("Expecting an integer type to specify the length of the array");
    	}
    	
    	// TODO Shane
    	return 0;
    }

    public void print(Context c)
    {
        print(c, "Exp position at: " + pos);
        print(c, "Current type is: " + getTypeName());
    }

    void print(Context c, String s) // static?
    {
        // TODO could be a method of context
        for (Integer i = 0; i < c.getIndent(); ++i) {
            System.out.print("\t");
        }

        System.out.println(s);
    }

    private Integer pos;
}