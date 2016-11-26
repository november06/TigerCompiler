package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeFieldsExp extends Exp 
{
    public TypeFieldsExp(Integer pos, Exp typeField)
    {
        this(pos, null, typeField);
    }

    public TypeFieldsExp(Integer pos, Exp typeFields, Exp typeField)
    {
        super(pos);

        typeFields = typeFields;
        typeField = typeField; 
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    Exp typeField;
    Exp typeFields;
}