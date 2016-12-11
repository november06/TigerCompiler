package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
    public void print()
    {
        super.print();
        if (head != null)
        {
            head.print();
        }
        tail.print(); // TODO validation: tail is declaration
        System.out.println();
    }

    DeclarationListExp head; // could be null 
    Exp tail;
}