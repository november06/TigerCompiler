package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeDefinitionExp extends Exp 
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
        return "TypeDefinitionExp";
    }

    @Override
    public void print()
    {
        super.print();
        if (type == ID)
        {
            System.out.print("ID: ");
            System.out.print(id);
        }
        else if (type == RECORD)
        {
            System.out.print("RECORD: ");
            typeFields.print();
            
        }
        else if (type == ARRAY)
        {
            System.out.print("ARRAY of: ");
            System.out.print(id);
        }
    }

    private String id; 
    private Integer type;
    private TypeFieldsExp typeFields;
}