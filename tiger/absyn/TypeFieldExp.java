package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeFieldExp extends Exp 
{
    public TypeFieldExp(Integer pos, String id, String typeId)
    {
        super(pos);

        id = id;
        typeId = typeId; 
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
        return "TypeFieldExp";
    }

    @Override
    public void print()
    {
        super.print();
        System.out.print(id);
        System.out.print(" : ");
        System.out.print(typeId);
    }

    String id;
    String typeId;
}