package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class AssignExp extends Exp
{
    public AssignExp(Integer pos, LvalueExp left, Exp right) {
        super(pos);

        this.left = left; 
        this.right = right;
    }

    @Override
    public void getValue(TigerValue v) { 
        v.SetNil();
     }

    @Override
    void getType(TigerType t) {
        // TODO
    }

    @Override
    public String getTypeName() 
    {
        return "AssignExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "left: ");
        left.print(c);
        print(c, ":=");
        print(c, "right: ");
        right.print(c);
        c.popLevel();
    }

    private LvalueExp left;
    private Exp right;
}