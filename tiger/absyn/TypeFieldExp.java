package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeFieldExp extends Exp 
{
    public TypeFieldExp(Integer pos, Exp id, Exp typeId)
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

    Exp id;
    Exp typeId;
}