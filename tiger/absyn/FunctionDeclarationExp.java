package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class FunctionDeclarationExp extends Declaration 
{
    public FunctionDeclarationExp(Integer pos, String name, TypeFieldsExp typeFields, Exp body)
    {
        this(pos, name, typeFields, null, body);
    }

    public FunctionDeclarationExp(Integer pos, String name, TypeFieldsExp typeFields, String returnType, Exp body)
    {
        super(pos);

        this.name = name;
        this.typeFields = typeFields;
        this.returnType = returnType;
        this.body = body;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
    	// try end type definition sequence
    	// tryStart function sequence
        // TODO
        return  TigerSimpleType.TigerIntegerType;
    }
    
    @Override 
    public void checkType(Context c) throws TigerTypeException {
    	
    }

    @Override
    public String getTypeName() 
    {
        return "FunctionDeclarationExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "function name is: " + name);
        print(c, "parameter list: ");
        typeFields.print(c);
        if (returnType != null) 
        {
            print(c, "return type is " + returnType);
        }
        else 
        {
            print(c, "no return type");
        }
        print(c, "function body is :");
        body.print(c);
        c.popIndentLevel();
    }

    private String name; 
    private TypeFieldsExp typeFields;
    private String returnType;
    private Exp body;
}