package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;
import java.util.ArrayList;

public class ListExp extends Exp
{
    public ListExp(Integer pos, Exp e)
    {
        this(pos, null, e);
    }

    public ListExp(Integer pos, ListExp head, Exp tail) 
    {
        super(pos);

        this.head = head;
        this.tail = tail;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }

    @Override
    public String getTypeName() 
    {
        return "ListExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        if (head != null) 
        {
            print(c, "head: ");
            head.print(c);
        }
        else 
        {
            print(c, "head is null");
        }

        if (tail != null) {
            print(c, "tail: ");
            tail.print(c);
        }
        else 
        {
            print(c, "tail is null");
        }
        c.popLevel();
    }
    
    public ArrayList<TigerType> getTigerTypeList()
    {
    	// TODO 
    	return new ArrayList<TigerType>();
    }

    private ListExp head;
    private Exp tail; // could be null
}