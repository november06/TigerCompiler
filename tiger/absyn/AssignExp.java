package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class AssignExp extends Exp
{
    public AssignExp(Integer pos, LvalueExp left, Exp right) {
        super(pos);

        left = left; 
        right = right;
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
    public void print()
    {
        // TODO validation type of left should be same as type of right
        super.print();
        left.print();
        System.out.print(":=");
        right.print();
        System.out.println();
    }

    private LvalueExp left;
    private Exp right;
}