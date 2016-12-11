package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class SeqExp extends Exp
{
    public SeqExp(Integer pos, Exp e)
    {
        this(pos, null, e);
    }

    public SeqExp(Integer pos, SeqExp head, Exp tail) 
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

    @Override
    public String getTypeName() 
    {
        return "SeqExp";
    }

    @Override
    public void print()
    {
        super.print();
        if (head != null) 
        {
            head.print();
        }
        tail.print();
        System.out.println();
    }

    private SeqExp head;
    private Exp tail; // could be null
}