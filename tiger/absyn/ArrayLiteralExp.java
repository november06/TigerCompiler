package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class  ArrayLiteralExp extends Exp
{
    public  ArrayLiteralExp(Integer pos, String typeName, Exp count, Exp /*actually adding another abstract class type is better*/ base)
    {
        super(pos);

        this.typename = typeName;
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
        return "ArrayLiteralExp";
    }

    @Override
    public void print()
    {
        super.print();
        // TODO validation count is of type int
        System.out.print(typename);
        countExp.print();
        baseDefinitionExp.print();  // TODO validation what's the requirement of base?
        System.out.println();
    }
    
    private String typename;
    private Exp countExp;
    private Exp baseDefinitionExp;
}