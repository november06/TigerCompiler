package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class ForExp extends Exp
{
    public ForExp(Integer pos, String id, Exp eStart, Exp eEnd, Exp eAction) 
    {
        super(pos);

        idName = id;
        this.eStart = eStart;
        this.eEnd = eEnd;
        this.eAction = eAction;
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
        return "ForExp";
    }

    @Override
    public void print()
    {
        super.print();
        // TODO validation eStart and eEnd of type integer
        System.out.print(idName);
        eStart.print();
        eEnd.print();
        eAction.print();
        System.out.println();
    }

    private String idName;
    private Exp eStart, eEnd;
    private Exp eAction;
}