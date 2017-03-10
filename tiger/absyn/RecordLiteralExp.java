package tiger.absyn;
import tiger.TigerValue;
import java.util.ArrayList;
import java.util.Map;

import tiger.others.*;

public class RecordLiteralExp extends Exp
{
    public RecordLiteralExp(Integer pos, String recordTypeName, FieldListExp fl)
    {
        super(pos);

        name = recordTypeName;
        fieldList = fl;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	// TODO incorrect, should check with the record type definition
        TigerType definitionType = c.findType(name);
        if (!(definitionType instanceof TigerRecordType))
        {
        	throw new TigerTypeException("Record literal definition, expecting a record type");
        }
        TigerRecordType result = (TigerRecordType)definitionType;
        
        ArrayList<RecordField> expectedTypes = result.getRecordFieldList(); // TODO do we pass context in?
        ArrayList<RecordField> fieldIdTypeList = fieldList.getElementTypeList(c); 
        
        // make sure the two list matches
        if (expectedTypes.size() != fieldIdTypeList.size()) 
        {
        	throw new TigerTypeException("Record literal's length is not valid.");
        }
        
        for (int i = 0; i < expectedTypes.size(); ++i) {
        	RecordField expectedType = expectedTypes.get(i);
        	RecordField typeListItem = fieldIdTypeList.get(i);
        	if (expectedType.getFieldType() != typeListItem.getFieldType()
        	|| expectedType.getFieldName() != typeListItem.getFieldName())
        	{
        		throw new TigerTypeException("Mismatch record literal and its type field");
        	}
        }
        
        return result;
    }

    @Override
    public String getTypeName() 
    {
        return "RecordLiteralExp";
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