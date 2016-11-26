package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class SeqExp extends Exp
{
    public SeqExp(Integer pos, Exp e)
    {
        this(pos, e, null);
    }

    public SeqExp(Integer pos, Exp head, Exp tail) 
    {
        super(pos);

        head = head;
        tail = tail;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private Exp head; // TODO or SeqExp?
    private Exp tail; // could be null
}