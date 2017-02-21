package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class RecordLiteralExp extends Exp
{
    public RecordLiteralExp(Integer pos, String recordName, FieldListExp fl)
    {
        super(pos);

        name = recordName;
        fieldList = fl;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
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