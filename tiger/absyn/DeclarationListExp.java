package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
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