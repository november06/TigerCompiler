package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class WhileExp extends Exp
{
    public WhileExp(Integer pos, Exp condition, Exp execute) 
    {
        super(pos);

        condition = condition;
        execute = execute;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private Exp condition;
    private Exp execute;
}