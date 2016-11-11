package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class IfElseExp extends Exp
{
    public IfElseExp(Integer pos, Exp condition, Exp executeIf) 
    {
        condition = condition;
        executeIf = executeIf;
    }

    public IfElseExp(Integer pos, Exp condition, Exp executeIf, Exp executeElse) 
    {
        condition = condition;
        executeIf = executeIf;
        executeElse = executeElse;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {

    }

    private Exp condition;
    private Exp executeIf;
    private Exp executeElse;
}