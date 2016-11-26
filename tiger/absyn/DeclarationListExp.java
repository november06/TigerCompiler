package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class DeclarationListExp extends Exp
{
    public DeclarationListExp(Integer pos, Exp d)
    {
        this(pos, d, null);
    }

    public DeclarationListExp(Integer pos, Exp d, Exp dl) 
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

    Exp head; // could be null 
    Exp tail;
}