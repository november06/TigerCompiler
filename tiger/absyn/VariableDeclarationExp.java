package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class VariableDeclarationExp extends Declaration 
{
    public VariableDeclarationExp(Integer pos, String id, Exp exp)
    {
        this(pos, id, null, exp);
    }

    public VariableDeclarationExp(Integer pos, String id, String typeId, Exp exp)
    {
        super(pos);

        this.id = id; 
        this.typeid = typeId;
        this.exp = exp;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	// try end type definition sequence
    	// try end function sequence
    	c.onVariableDeclaration();
    	if (typeid == null) {
    	    c.addVariable(id, exp.getType(c));
    	}
    	else 
    	{
    		// check type
    		TigerType expType = exp.getType(c);
    		if (expType != c.findType(typeid))
    		{
    			throw new TigerTypeException("variable initialization exp should be of the same type of the type specified.");
    		}
    		c.addVariable(id, c.findType(typeid));
    	}
        return null;
    }
    
    @Override
    public String getTypeName() 
    {
        return "VariableDeclarationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "name is " + id);

        if (typeid != null)
        {
            print(c, "type is " + typeid);
        }
        else 
        {
            print(c, "no type specified");
        }
        print(c, "initial value is ");
        exp.print(c);
        c.popIndentLevel();
    }

    private String id; 
    private String typeid;
    private Exp exp;
}