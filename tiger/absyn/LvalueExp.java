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
    public TigerType getType(Context c) {
        if (this.internalType == identifier) {
            return c.findVariableType(identifierName);
        }
        else if (this.internalType == fieldOfRecord) {
            TigerType baseType = baseLvalue.getType(c);
            if (baseType != null) {
                return baseType.getMemberType(c, fieldName);
            }
            return null;
        }
        else if (this.internalType == itemOfArray) {
            TigerType baseType = baseLvalue.getType(c);
            // seems impossible to get the value of the index 
            if (baseType != null) {
                return baseType.getElementType(c);
            }
            return null;
        }

        return null;
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