package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class ArrayDefinitionExp extends Exp
{
    public ArrayDefinitionExp(Integer pos, String arrayName, Exp count, Exp /*actually adding another abstract class type is better*/ base)
    {
        super(pos);

        name = arrayName;
        countExp = count;
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

    @Override
    public String getTypeName() 
    {
        return "ArrayDefinitionExp";
    }

    @Override
    public void print()
    {
        super.print();
        // TODO validation count is of type int
        System.out.print(name);
        countExp.print();
        baseDefinitionExp.print();  // TODO validation what's the requirement of base?
        System.out.println();
    }
    
    private String name;
    private Exp countExp;
    private Exp baseDefinitionExp;
}