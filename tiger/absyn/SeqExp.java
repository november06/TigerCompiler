package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class SeqExp extends Exp
{
    public SeqExp(Integer pos)
    {
        this(pos, null, null);
    }
    
    public SeqExp(Integer pos, Exp e)
    {
        this(pos, null, e);
    }

    public SeqExp(Integer pos, SeqExp head, Exp tail) 
    {
        super(pos);

        this.head = head;
        this.tail = tail;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        if (tail == null && head == null)
        {
        	return null;
        }
        if (tail == null)
        {
        	return head.getType(c);
        }
        else 
        {
        	return tail.getType(c);
        }
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "SeqExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        if (head != null) 
        {
            print(c, "head ");
            head.print(c);
        }
        else 
        {
            print(c, "head is null");
        }
        if (tail != null)
        {
            print(c, "tail ");
            tail.print(c);
        }
        else 
        {
            print(c, "tail is null");
        }
        c.popIndentLevel();
    }

    private SeqExp head;
    private Exp tail; // could be null
}