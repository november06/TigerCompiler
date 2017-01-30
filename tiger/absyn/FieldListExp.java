package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class FieldListExp extends Exp
{
    public FieldListExp(Integer pos)
    {
        this(pos, null, null, null);
    }

    public FieldListExp(Integer pos, String id, Exp e)
    {
        this(pos, null, id, e);
    }

    public FieldListExp(Integer pos, FieldListExp fl, String id, Exp e) 
    {
        super(pos);

        head = fl;
        this.id = id; 
        exp = e;
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
        return "FieldListExp";
    }

    @Override
    public void print()
    {
        super.print();
        if (head != null)
        {
            head.print();
        }

        if (id != null) {
            System.out.print(id);
        }
        if (exp != null) {
            exp.print(); // TODO validation : exp is a type ?
        }
        System.out.println();
    }

    FieldListExp head;
    String id;
    Exp exp;
}