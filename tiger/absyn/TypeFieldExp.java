package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class TypeFieldExp extends Exp 
{
    public TypeFieldExp(Integer pos, String id, String typeId)
    {
        super(pos);

        this.id = id;
        this.typeId = typeId; 
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
        return "TypeFieldExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "field id " + id);
        print(c, "defined by");
        print(c, typeId);
        c.popIndentLevel();
    }

    String id;
    String typeId;
}