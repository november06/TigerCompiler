package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeDefinitionExp extends Exp 
{
    public static final Integer ID = 0, RECORD = 1, ARRAY = 2;

    public TypeDefinitionExp(Integer pos, String id, Exp typeDef)
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