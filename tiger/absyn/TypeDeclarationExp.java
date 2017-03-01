package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

// alias
public class TypeDeclarationExp extends Declaration 
{
    public TypeDeclarationExp(Integer pos, String id, TypeDefinitionExp typeDef)
    {
        super(pos);

        this.id = id; 
        def = typeDef;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "TypeDeclarationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "type id " + id);
        print(c, "type defintion ");
        def.print(c);
        c.popIndentLevel();
    }

    private String id; 
    private TypeDefinitionExp def;
}