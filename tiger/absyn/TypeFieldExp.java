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
    public String getTypeName() 
    {
        return "TypeFieldExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "field id " + id);
        print(c, "defined by");
        print(c, typeId);
        c.popLevel();
    }

    String id;
    String typeId;
}