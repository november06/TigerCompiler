package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "-");
        print(c, "original value is ");
        innerExp.print(c);
        c.popLevel();
    }

    private Exp innerExp;
}