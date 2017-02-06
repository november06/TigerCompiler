package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

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
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "type name " + name);
        if (fieldList != null) {
            print(c, "field list ");
            fieldList.print(c);
        }
        else 
        {
            print(c, "field list is empty");
        }

        c.popLevel();
    }

    private String name;
    private FieldListExp fieldList; // could be null?
}