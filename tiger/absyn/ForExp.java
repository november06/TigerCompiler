package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class ForExp extends Exp
{
    public ForExp(Integer pos, String id, Exp eStart, Exp eEnd, Exp eAction) 
    {
        super(pos);

        idName = id;
        eStart = eStart;
        eEnd = eEnd;
        eAction = eAction;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private String idName;
    private Exp eStart, eEnd;
    private Exp eAction;
}