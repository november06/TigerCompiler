package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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

    abstract void getValue(TigerValue v);

    abstract void getType(TigerType v);

    abstract String getTypeName();

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