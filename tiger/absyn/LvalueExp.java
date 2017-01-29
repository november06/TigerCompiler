package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

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
    public void getType(TigerType v) {
        // TODO
    }

    @Override
    public String getTypeName() 
    {
        return "LvalueExp";
    }

    @Override
    public void print()
    {
        super.print();
        
        if (internalType == identifier)
        {
            System.out.print("identifier");

            System.out.println(identifierName);
            // TODO validation identifier is available
        }
        else if (internalType == fieldOfRecord)
        {
            System.out.print("fieldOfRecord");

            baseLvalue.print();

            System.out.println(fieldName);
            // TODO validation baseLvalue is valid
            // TODO validation fieldName is available for baseLvalue's type
        }
        else if (internalType == itemOfArray)
        {
            System.out.print("itemOfArray");

            baseLvalue.print();

            indexExp.print();

            System.out.println();
            // TODO validation baseLvalue is valid, is an array
            // TODO indexExp is an integer type
        }
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