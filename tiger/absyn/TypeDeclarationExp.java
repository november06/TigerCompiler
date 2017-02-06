package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class TypeDeclarationExp extends Declaration 
{
    public TypeDeclarationExp(Integer pos, String id, TypeDefinitionExp typeDef)
    {
        super(pos);

        this.id = id; 
        def = typeDef;
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
        return "TypeDeclarationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "type id " + id);
        print(c, "type defintion ");
        def.print(c);
        c.popLevel();
    }

    private String id; 
    private TypeDefinitionExp def;
}