package tiger.absyn;
import tiger.TigerValue;
import tiger.others.*;

public class  ArrayLiteralExp extends Exp
{
    public ArrayLiteralExp(Integer pos, String typeName, Exp count, Exp initialValue)
    {
        super(pos);

        this.typename = typeName;
        countExp = count;
        this.initialValue = initialValue;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	int arrayLength = countExp.getCompileTimeIntValue(c); // TODO or do we use dynamic array length? (runtime)
        
        TigerType baseType = c.findType(typename);
        TigerType initialValueType = initialValue.getType(c);
        
        if (baseType != initialValueType) // TODO not correct, consider null and record type type coerce
        {
        	throw new TigerTypeException("unexpected type to initialize the array literal");
        }

        return new TigerArrayType(baseType, arrayLength);
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
        initialValue.print(c);

        c.popIndentLevel();
    }
    
    private String typename;
    private Exp countExp;
    private Exp initialValue;
}