package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class FunctionDeclarationExp extends Exp 
{
    public FunctionDeclarationExp(Integer pos, String name, TypeFieldsExp typeFields, Exp body)
    {
        this(pos, name, typeFields, null, body);
    }

    public FunctionDeclarationExp(Integer pos, String name, TypeFieldsExp typeFields, String returnType, Exp body)
    {
        super(pos);

        name = name;
        typeFields = typeFields;
        returnType = returnType;
        body = body;
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
        return "FunctionDeclarationExp";
    }

    @Override
    public void print()
    {
        super.print();
        System.out.print(name);
        typeFields.print();
        if (returnType != null) 
        {
            System.out.print(returnType);
        }
        body.print();
        System.out.println();
    }

    private String name; 
    private TypeFieldsExp typeFields;
    private String returnType;
    private Exp body;
}