package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeDefinitionExp extends Exp 
{
    public static final Integer ID = 0, RECORD = 1, ARRAY = 2;

    public TypeDefinitionExp(Integer pos, Integer type, String id)
    {
        super(pos);

        id = id; 
        type = type;
    }

    public TypeDefinitionExp(Integer pos, Exp typeFields)
    {
        super(pos);

        type = RECORD; 
        typeFields = typeFields;
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
    private Integer type;
    private Exp typeFields;
}