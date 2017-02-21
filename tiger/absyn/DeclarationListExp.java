package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class DeclarationListExp extends Exp
{
    public DeclarationListExp(Integer pos, Exp d)
    {
        this(pos, null, d);
    }

    public DeclarationListExp(Integer pos, DeclarationListExp dl, Exp d) 
    {
        super(pos);

        tail = d;
        head = dl;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }

    @Override
    public String getTypeName() 
    {
        return "DeclarationListExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
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
        c.popLevel();
    }

    DeclarationListExp head; // could be null 
    Exp tail;
}