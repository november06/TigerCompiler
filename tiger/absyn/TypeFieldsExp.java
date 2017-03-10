package tiger.absyn;
import java.util.ArrayList;
import java.util.Arrays;

import tiger.TigerValue;

import tiger.others.*;

// possible usage
// 1 record definition
// 2 function declaration
// 3 procedure declaration
public class TypeFieldsExp extends Exp 
{
    public TypeFieldsExp(Integer pos, TypeFieldExp typeField)
    {
        this(pos, null, typeField);
    }

    public TypeFieldsExp(Integer pos, TypeFieldsExp typeFields, TypeFieldExp typeField)
    {
        super(pos);

        this.typeFields = typeFields;
        this.typeField = typeField; 
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	return null;
    }
    
    public ArrayList<TigerType> getTigerTypeList(Context c) throws TigerTypeException
    {
    	ArrayList<TigerType> resultCandidate = new ArrayList<TigerType>();
        if (typeField != null)
        {
        	resultCandidate.add(typeField.getType(c));
        }
        
        if (typeFields != null)
        {
        	ArrayList<TigerType> tail = typeFields.getTigerTypeList(c);
        	resultCandidate.addAll(tail);
        }
        
        
        return resultCandidate;
    }
    
    // TODO rename record field
    public ArrayList<RecordField> getTigerRecordTypeList(Context c) throws TigerTypeException
    {
    	ArrayList<RecordField> result = new ArrayList<RecordField>();
    	if (typeField != null)
    	{
    		result.add(new RecordField(typeField.getFieldId(), typeField.getType(c)));
    	}
    	
    	if (typeFields != null)
    	{
    		result.addAll(typeFields.getTigerRecordTypeList(c));
    	}
    	return result;
    }

    @Override
    public String getTypeName() 
    {
        return "TypeFieldsExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        if (typeFields != null)
        {
            print(c, "type fields are");
            typeFields.print(c);
        }
        else 
        {
            print(c, "type fields is null");
        }

        if (typeField != null) {
            print(c, "type field is null");
            typeField.print(c);
        }
        else 
        {
            print(c, "type field is null");
        }
        c.popIndentLevel();
    }

    TypeFieldExp typeField;
    TypeFieldsExp typeFields;
}