package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public abstract class LetExp extends Exp
{
    public LetExp(Integer pos, Exp dl, Exp e)
    {
        super(pos);
        
        declarationList = dl; 
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

    private Integer pos;
    private Exp declarationList;
    private Exp exp;
}