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
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
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