package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "typename: " + typename);
        print(c, "count: ");
        countExp.print(c);
        
        print(c, "element value:");
        baseDefinitionExp.print(c);

        c.popLevel();
    }
    
    private String typename;
    private Exp countExp;
    private Exp baseDefinitionExp;
}