package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

// TODO SeqExp
public class ListExp extends Exp
{
    public ListExp(Integer pos, Exp e)
    {
        this(pos, e, null);
    }

    public ListExp(Integer pos, Exp head, Exp tail) 
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

    private Exp head;
    private Exp tail; // could be null
}