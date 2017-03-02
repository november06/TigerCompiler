package tiger.absyn;
import java.util.ArrayList;
import java.util.Arrays;

import tiger.TigerValue;

import tiger.others.*;

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
    	return new TigerRecordType(getTigerTypeList(c));
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