package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

// TODO SeqExp
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
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public TigerType getType(Context c) {
        // TODO
        return new TigerType(0);
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

    private ListExp head;
    private Exp tail; // could be null
}