package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class LetExp extends Exp
{
    public LetExp(Integer pos, DeclarationListExp dl, SeqExp e)
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

    @Override
    public String getTypeName() 
    {
        return "LetExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "declaration list: ");
        declarationList.print(c);
        print(c, "sequence expressions: ");
        exp.print(c);
        c.popLevel();
    }

    private DeclarationListExp declarationList;
    private SeqExp exp;
}