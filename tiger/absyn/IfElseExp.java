package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class IfElseExp extends Exp
{
    public IfElseExp(Integer pos, Exp condition, Exp executeIf) 
    {
        this(pos, condition, executeIf, null);
    }

    public IfElseExp(Integer pos, Exp condition, Exp executeIf, Exp executeElse) 
    {
        super(pos);

        this.condition = condition;
        this.executeIf = executeIf;
        this.executeElse = executeElse;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }

    @Override
    public String getTypeName() 
    {
        return "IfElseExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "condition: ");
        condition.print(c);
        print(c, "if body: ");
        executeIf.print(c);
        if (executeElse != null) {
            print(c, "else body: ");
            executeElse.print(c);
        }
        else 
        {
            print(c, "no else");
        }

        c.popLevel();
    }

    private Exp condition;
    private Exp executeIf;
    private Exp executeElse; // could be null
}