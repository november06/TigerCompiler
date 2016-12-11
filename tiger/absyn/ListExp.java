package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
        return "ListExp";
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

    private ListExp head;
    private Exp tail; // could be null
}