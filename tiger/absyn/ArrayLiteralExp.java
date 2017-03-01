package tiger.absyn;
import tiger.TigerValue;
import tiger.others.*;

public class  ArrayLiteralExp extends Exp
{
    public  ArrayLiteralExp(Integer pos, String typeName, Exp count, TypeDefinitionExp base)
    {
        super(pos);

        this.typename = typeName;
        countExp = count;
        baseDefinitionExp = base;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	int arrayLength = countExp.getCompileTimeIntValue(c);
    	TigerArrayType result = new TigerArrayType(baseDefinitionExp.getType(c), arrayLength);
        return result;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "ArrayLiteralExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "typename: " + typename);
        print(c, "count: ");
        countExp.print(c);
        
        print(c, "element value:");
        baseDefinitionExp.print(c);

        c.popIndentLevel();
    }
    
    private String typename;
    private Exp countExp;
    private TypeDefinitionExp baseDefinitionExp;
}