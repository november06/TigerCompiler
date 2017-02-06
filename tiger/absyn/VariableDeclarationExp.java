package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;
import tiger.context.Context;

public class VariableDeclarationExp extends Declaration 
{
    public VariableDeclarationExp(Integer pos, String id, Exp exp)
    {
        this(pos, id, null, exp);
    }

    public VariableDeclarationExp(Integer pos, String id, String typeId, Exp exp)
    {
        super(pos);

        this.id = id; 
        this.typeid = typeId;
        this.exp = exp;
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
        return "VariableDeclarationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "name is " + id);

        if (typeid != null)
        {
            print(c, "type is " + typeid);
        }
        else 
        {
            print(c, "no type specified");
        }
        print(c, "initial value is ");
        exp.print(c);
        c.popLevel();
    }

    private String id; 
    private String typeid;
    private Exp exp;
}