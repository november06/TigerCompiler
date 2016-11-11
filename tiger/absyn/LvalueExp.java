package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class LvalueExp extends Exp
{
    public final static Integer identifier = 0, fieldOfRecord = 1, itemOfArray = 2;

    public LvalueExp(Integer pos, String idName) 
    {
        internalType = identifier;
        identifierName = idName;
    }

    public LvalueExp(Integer pos, LvalueExp lvalueExp, String fieldName)
    {
        internalType = fieldOfRecord;
        baseLvalue = lvalueExp;
        fieldName = fieldName;
    }

    public LvalueExp(Integer pos, LvalueExp lvalueExp, Exp indexExp)
    {
        // TODO validate indexExp's type'
        internalType = itemOfArray;
        baseLvalue = lvalueExp;
        indexExp = indexExp;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {

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