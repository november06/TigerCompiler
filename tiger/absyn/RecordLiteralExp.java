package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class RecordLiteralExp extends Exp
{
    public RecordLiteralExp(Integer pos, String recordName, FieldListExp fl)
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

    @Override
    public String getTypeName() 
    {
        return "RecordLiteralExp";
    }

    @Override
    public void print()
    {
        super.print();
        System.out.print(name);
        if (fieldList != null) {
            fieldList.print();
        }

        System.out.println();
        // TODO validation name used?  name of current scope
    }

    private String name;
    private FieldListExp fieldList; // could be null?
}