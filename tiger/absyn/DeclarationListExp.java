package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class DeclarationListExp extends Exp
{
    public DeclarationListExp(Integer pos, Declaration d)
    {
        this(pos, null, d);
    }

    public DeclarationListExp(Integer pos, DeclarationListExp dl, Declaration d) 
    {
        super(pos);

        tail = d;
        head = dl;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        if (head != null)
        {
        	head.getType(c);
        }
        tail.getType(c);
        return  null;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "DeclarationListExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        if (head != null)
        {
            print(c, "head");
            head.print(c);
        }
        else 
        {
            print(c, "head is null");
        }
        tail.print(c);
        c.popIndentLevel();
    }

    DeclarationListExp head; // could be null 
    Declaration tail;
}