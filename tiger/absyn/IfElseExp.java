package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
        return "IfElseExp";
    }

    @Override
    public void print()
    {
        super.print();
        // TODO validation: condition should be Integer
        condition.print();
        // TODO validation: executeIf should be the same type of executeElse
        executeIf.print();
        executeElse.print();

        System.out.println();
    }

    private Exp condition;
    private Exp executeIf;
    private Exp executeElse; // could be null
}