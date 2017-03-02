package tiger.absyn;
import tiger.TigerValue;

import java.util.ArrayList;

import tiger.others.*;

public class FieldListExp extends Exp
{
    public FieldListExp(Integer pos)
    {
        this(pos, null, null, null);
    }

    public FieldListExp(Integer pos, String id, Exp e)
    {
        this(pos, null, id, e);
    }

    public FieldListExp(Integer pos, FieldListExp fl, String id, Exp e) 
    {
        super(pos);

        head = fl;
        this.id = id; 
        exp = e;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }

    @Override
    public String getTypeName() 
    {
        return "FieldListExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        if (head != null)
        {
            print(c, "head: ");
            head.print(c);
        }
        else 
        {
            print(c, "head is null");
        }

        if (id != null && exp != null) {
            print(c, "id: " +id);
            exp.print(c);
        }
        else if (id == null && exp == null)
        {
            print(c, "id and exp are null.");
        }
        else 
        {
            print(c, "UPEXPECTED: exp and id are not both null");
        }
        c.popIndentLevel();
    }
    
    public ArrayList<TigerType> getElementTypeList()
    {
        // TODO Shane
    	return new ArrayList<TigerType>();
    }

    FieldListExp head;
    String id;
    Exp exp;
}