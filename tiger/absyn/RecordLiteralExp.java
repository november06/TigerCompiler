package tiger.absyn;
import tiger.TigerValue;
import java.util.ArrayList;
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
    	// TODO incorrect, should check with the record type definition
        TigerRecordType result = new TigerRecordType(name);
        result.setSubTypes(fieldList.getElementTypeList());
        return result;
    }

    @Override
    public String getTypeName() 
    {
        return "RecordLiteralExp";
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
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

        c.popIndentLevel();
    }

    private String name;
    private FieldListExp fieldList; // could be null?
}