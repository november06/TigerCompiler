package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class UminusExp extends Exp
{
    public UminusExp(Integer pos, Exp e) 
    {
        super(pos);

        innerExp = e;
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
        return "UminusExp";
    }

    @Override
    public void print()
    {
        super.print();
        System.out.print("-");
        innerExp.print();
        System.out.println();
        // TODO validation innerExp is of type integer
    }

    private Exp innerExp;
}