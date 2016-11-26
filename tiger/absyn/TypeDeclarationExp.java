package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeDeclarationExp extends Exp 
{
    public TypeDeclarationExp(Integer pos, String id, Exp typeDef)
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

    private String id; 
    private Exp def;
}