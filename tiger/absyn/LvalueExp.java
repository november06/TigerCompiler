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

        // TODO validate indexExp's type'
        internalType = itemOfArray;

        baseLvalue = lvalueExp;
        this.indexExp = indexExp;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException {
        if (this.internalType == identifier) {
            return c.findVariableType(identifierName);
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
        		// TODO: to check furthur types?
        		throw new TigerTypeException("can't find the base type in the context");
        	}
        	if (this.internalType == fieldOfRecord) {
	            return baseType.getMemberType(c, fieldName);
	        }
	        else if (this.internalType == itemOfArray) {
	            return baseType.getElementType(c);
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
        c.pushLevel();
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
        c.popLevel();
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