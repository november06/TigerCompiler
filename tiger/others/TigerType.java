package tiger.others;
import java.util.ArrayList;

public class TigerType
{
    public final static Integer simple = 0, complexRecord = 1, complexArray = 2, alias = 3;
    public final static String TigerSimpleTypeNilName = "Nil";
    public final static String TigerSimpleTypeIntegerName = "Integer";
    public final static String TigerSimpleTypeStringName = "String";

    public TigerType(Integer subType)
    {
        this.subType = subType;
    }

    public TigerType getMemberType(Context c, String fieldName)
    {
        if (this.subType == complexRecord) {
            for (TigerType t: fields) {
                if (t.name == fieldName) {
                    return t;
                }
            }
            // didn't find
            return null;
        }
        else if (this.subType == alias) {
            TigerType t = c.findType(aliasName);
            if (t != null) {
                return t.getMemberType(c, fieldName);
            }
            return null;
        }
        return null;
    }

    public TigerType getElementType(Context c) {
        if (this.subType == complexArray) {
            return baseType;
        }
        else if (this.subType == alias) {
            TigerType t = c.findType(aliasName);
            if (t != null) {
                return t.getElementType(c);
            }
            return null;
        }
        return null;
    }
    
    private Integer subType;
    // simple: int, string, void, nil ?
    public String simpleTypeName;
    // record
    private ArrayList<TigerType> fields;
    // array 
    private TigerType baseType;
    // alias
    private String aliasName;

    private String name;
}