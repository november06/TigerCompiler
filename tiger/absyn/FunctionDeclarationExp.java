package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class FunctionDeclarationExp extends Exp 
{
    public FunctionDeclarationExp(Integer pos, String name, Exp typeFields, Exp body)
    {
        this(pos, name, typeFields, null, body);
    }

    public FunctionDeclarationExp(Integer pos, String name, Exp typeFields, String returnType, Exp body)
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

    private String name; 
    private Exp typeFields;
    private String returnType;
    private Exp body;
}