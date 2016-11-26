package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class ArrayDefinitionExp extends Exp
{
    public ArrayDefinitionExp(Integer pos, String arrayName, Exp e, Exp /*actually adding another abstract class type is better*/ base)
    {
        super(pos);

        name = arrayName;
        countExp = e;
        baseDefinitionExp = base;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }
    
    private String name;
    private Exp countExp;
    private Exp baseDefinitionExp;
}