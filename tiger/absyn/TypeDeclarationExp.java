package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeDeclarationExp extends Exp 
{
    public TypeDeclarationExp(Integer pos, String id, TypeDefinitionExp typeDef)
    {
        super(pos);

        id = id; 
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
    public void print()
    {
        super.print();
        System.out.print(id); // TODO put into global envrionment?
        def.print();
        System.out.println();
    }

    private String id; 
    private TypeDefinitionExp def;
}