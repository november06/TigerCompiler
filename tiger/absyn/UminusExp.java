package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class UminusExp extends Exp
{
    public UminusExp(Integer pos, Exp e) 
    {
        innerExp = e;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {

    }

    private Exp innerExp;
}