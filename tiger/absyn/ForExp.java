package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "variable name" + idName);
        print(c, "start: ");
        eStart.print(c);
        print(c, "end: ");
        eEnd.print(c);
        print(c, "action: ");
        eAction.print(c);
        c.popLevel();
    }

    private String idName;
    private Exp eStart, eEnd;
    private Exp eAction;
}