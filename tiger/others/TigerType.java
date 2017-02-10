package tiger.others;
import java.util.ArrayList;

public class TigerType
{
    public final static Integer simple = 0, complexRecord = 1, complexArray = 2, alias = 3;
    public final static String TigerSimpleTypeNilName = "Nil";
    public final static String TigerSimpleTypeIntegerName = "Integer";
    public final static String TigerSimpleTypeStringName = "String";
    
    public final static TigerType TigerIntegerType = new TigerType(simple, TigerSimpleTypeIntegerName);

    public TigerType(Integer subType)
    {
        this.subType = subType;
    }
    
    public TigerType(Integer subType, String tigerSimpleTypeName)
    {
    	// TODO verify it's simple type
    	this(subType);
    	this.simpleTypeName = tigerSimpleTypeName;
    }

    @Override
	public int hashCode() {
    	// TODO context alias 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseType == null) ? 0 : baseType.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((simpleTypeName == null) ? 0 : simpleTypeName.hashCode());
		result = prime * result + ((subType == null) ? 0 : subType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TigerType other = (TigerType) obj;
		if (baseType == null) {
			if (other.baseType != null)
				return false;
		} else if (!baseType.equals(other.baseType))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (simpleTypeName == null) {
			if (other.simpleTypeName != null)
				return false;
		} else if (!simpleTypeName.equals(other.simpleTypeName))
			return false;
		if (subType == null) {
			if (other.subType != null)
				return false;
		} else if (!subType.equals(other.subType))
			return false;
		return true;
	}

	public TigerType getMemberType(Context c, String fieldName) throws TigerTypeException 
    {
        if (this.subType == complexRecord) {
            for (TigerType t: fields) {
                if (t.name == fieldName) {
                    return t;
                }
            }
            // didn't find
            throw new TigerTypeException("Cannot fine the specified field");
        }
        else if (this.subType == alias) {
            TigerType t = c.findType(aliasName);
            if (t != null) {
                return t.getMemberType(c, fieldName);
            }
            throw new TigerTypeException("Cannot find the alias definition");
        }
        throw new TigerTypeException("unexpected status: getMemberType");
    }

    public TigerType getElementType(Context c) throws TigerTypeException {
        if (this.subType == complexArray) {
            return baseType;
        }
        else if (this.subType == alias) {
            TigerType t = c.findType(aliasName);
            if (t != null) {
                return t.getElementType(c);
            }
            throw new TigerTypeException("Cannot find the alias definition");
        }
        throw new TigerTypeException("unexpected status: getMemberType");
    }
    
    public Boolean isSimpleType()
    {
    	return subType == simple;
    }
    
    public Boolean isInteger()
    {
    	return isSimpleType() && this.simpleTypeName == TigerSimpleTypeIntegerName;
    }
    
    public Boolean isString()
    {
    	return isSimpleType() && this.simpleTypeName == TigerSimpleTypeStringName;
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