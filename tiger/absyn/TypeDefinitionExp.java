package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class TypeDefinitionExp extends Declaration 
{
    public static final Integer ID = 0, RECORD = 1, ARRAY = 2;

    public TypeDefinitionExp(Integer pos, Integer type, String id)
    {
        super(pos);

        this.id = id; 
        this.type = type;
    }

    public TypeDefinitionExp(Integer pos, TypeFieldsExp typeFields)
    {
        super(pos);

        type = RECORD; 
        this.typeFields = typeFields;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "TypeDefinitionExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        if (type == ID)
        {
            print(c, "ID: " + id);
        }
        else if (type == RECORD)
        {
            print(c, "RECORD: ");
            typeFields.print(c);
            
        }
        else if (type == ARRAY)
        {
            print(c, "ARRAY of: " + id);
        }
        c.popIndentLevel();
    }

    private String id; 
    private Integer type;
    private TypeFieldsExp typeFields;
}