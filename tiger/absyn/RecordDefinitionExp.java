package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class RecordDefinitionExp extends Exp
{
    public RecordDefinitionExp(Integer pos, String recordName, Exp fl)
    {
        super(pos);

        name = recordName;
        fieldList = fl;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    private String name;
    private Exp /*FieldList TODO*/ fieldList; // could be null?
}