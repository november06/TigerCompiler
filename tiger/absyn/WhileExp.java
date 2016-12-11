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

    @Override
    public String getTypeName() 
    {
        return "WhileExp";
    }

    @Override
    public void print()
    {
        super.print();
        // TODO validation condition Integer
        // TODO validation what's the type of execute
        condition.print();
        execute.print();
        System.out.println();
    }

    private Exp condition;
    private Exp execute;
}