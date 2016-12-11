package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class VariableDeclarationExp extends Exp 
{
    public VariableDeclarationExp(Integer pos, String id, Exp exp)
    {
        this(pos, id, null, exp);
    }

    public VariableDeclarationExp(Integer pos, String id, String typeId, Exp exp)
    {
        super(pos);

        id = id; 
        typeid = typeId;
        exp = exp;
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
    public void print()
    {
        super.print();
        System.out.print(id);
        if (typeid != null)
        {
            System.out.print(typeid);
        }
        exp.print();
        System.out.println();
    }

    private String id; 
    private String typeid;
    private Exp exp;
}