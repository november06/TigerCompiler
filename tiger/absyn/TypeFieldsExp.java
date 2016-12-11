package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class TypeFieldsExp extends Exp 
{
    public TypeFieldsExp(Integer pos, TypeFieldExp typeField)
    {
        this(pos, null, typeField);
    }

    public TypeFieldsExp(Integer pos, TypeFieldsExp typeFields, TypeFieldExp typeField)
    {
        super(pos);

        typeFields = typeFields;
        typeField = typeField; 
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
        return "TypeFieldsExp";
    }

    @Override
    public void print()
    {
        super.print();
        if (typeFields != null)
        {
            typeFields.print();
        }
        typeField.print();
        System.out.println();
    }

    TypeFieldExp typeField;
    TypeFieldsExp typeFields;
}