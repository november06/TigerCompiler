package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
    public void print()
    {
        super.print();
        declarationList.print();
        if (exp != null) { 
            exp.print();
        }
        System.out.println();
    }

    private DeclarationListExp declarationList;
    private SeqExp exp;
}