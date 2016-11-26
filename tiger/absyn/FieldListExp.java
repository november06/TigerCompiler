package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class FieldListExp extends Exp
{
    public FieldListExp(Integer pos, String id, Exp e)
    {
        this(pos, null, id, e);
    }

    public FieldListExp(Integer pos, Exp fl, String id, Exp e) 
    {
        super(pos);

        head = fl;
        id = id; 
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

    Exp head;
    String id;
    Exp exp;
}