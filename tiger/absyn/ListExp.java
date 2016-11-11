package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

// TODO SeqExp
public class ListExp extends Exp
{
    public ListExp(Integer pos, Exp e)
    {
        head = e;
    }

    public ListExp(Integer pos, Exp head, Exp tail) 
    {
        head = head;
        tail = tail;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {

    }

    private Exp head; // TODO or SeqExp?
    private Exp tail;
}