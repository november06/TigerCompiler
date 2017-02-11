package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class LetExp extends Exp
{
    public LetExp(Integer pos, DeclarationListExp dl, SeqExp e)
    {
        super(pos);
        
        declarationList = dl; 
        exp = e;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return new TigerType(0);
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