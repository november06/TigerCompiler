package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class WhileExp extends Exp
{
    public WhileExp(Integer pos, Exp condition, Exp execute) 
    {
        super(pos);

        this.condition = condition;
        this.execute = execute;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public TigerType getType(Context c) {
        // TODO
        return new TigerType(0);
    }

    @Override
    public String getTypeName() 
    {
        return "WhileExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "condition is ");
        condition.print(c);
        print(c, "execute body is ");
        execute.print(c);
        c.popLevel();
    }

    private Exp condition;
    private Exp execute;
}