package tiger.absyn;
import tiger.TigerValue;

import tiger.others.*;

public class LvalueExp extends Exp
{
    public final static Integer identifier = 0, fieldOfRecord = 1, itemOfArray = 2;

    public LvalueExp(Integer pos, String idName) 
    {
        super(pos);

        internalType = identifier;

        identifierName = idName;
    }

    public LvalueExp(Integer pos, LvalueExp lvalueExp, String fieldName)
    {
        super(pos);

        internalType = fieldOfRecord;

        baseLvalue = lvalueExp;
        this.fieldName = fieldName;
    }

    public LvalueExp(Integer pos, LvalueExp lvalueExp, Exp indexExp)
    {
        super(pos);

        internalType = itemOfArray;

        baseLvalue = lvalueExp;
        this.indexExp = indexExp;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException {
        if (this.internalType == identifier) {
        	TigerType result = c.findIdentifierType(identifierName);
        	if (result instanceof TigerFunctionType) {
        		throw new TigerTypeException("Function type encountered while variable expeced in lvalue.");
        	}
            return result;
        }
        else {
        	TigerType baseType = null;
        	if (this.internalType == fieldOfRecord || this.internalType == itemOfArray) {
        		baseType = baseLvalue.getType(c);
        	}
        	else 
        	{
        		throw new TigerTypeException("internal error, incorrect internal state of lvalue expressions");
        	}

        	if (baseType == null)
        	{
        		throw new TigerTypeException("can't find the base type in the context");
        	}
        	// TODO ALIAS do we need passing context into the functions? or we could use context in this function
        	// depends how we handle alias, right? do we return an instance of tiger type alias here
        	// which means I should remove all alias definition when handling array type/record type definition
        	if (this.internalType == fieldOfRecord) {
	            return baseType.getMemberType(fieldName);
	        }
	        else if (this.internalType == itemOfArray) {
	            return baseType.getElementType();
	        }
        }

        throw new TigerTypeException("internal error, incorrect internal state of lvalue expressions");
    }

    @Override
    public String getTypeName() 
    {
        return "LvalueExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        
        if (internalType == identifier)
        {
           print(c, "identifier " + identifierName);
        }
        else if (internalType == fieldOfRecord)
        {
            print(c, "fieldOfRecord");
            
            print(c, "base ");
            baseLvalue.print(c);

            print(c, "field name is " + fieldName);
        }
        else if (internalType == itemOfArray)
        {
            print(c, "itemOfArray");

            print(c, "base ");
            baseLvalue.print(c);

            print(c, "index ");
            indexExp.print(c);
        }
        c.popIndentLevel();
    }

    private Integer internalType;

    // type 0
    private String identifierName;
    // type 1 and type 2
    LvalueExp baseLvalue;

    // type 1 
    String fieldName;

    // type 2
    Exp indexExp;
}