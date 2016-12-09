package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeFieldExp extends Exp 
{
    public TypeFieldExp(Integer pos, String id, String typeId)
    {
        super(pos);

        id = id;
        typeId = typeId; 
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    String id;
    String typeId;
}