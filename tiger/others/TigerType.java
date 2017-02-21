package tiger.others;
import java.util.ArrayList;

public abstract class TigerType
{
	// simple type 
    public Boolean isInteger() {return false;}

    public Boolean isString() {return false;}

    public Boolean isNil() {return false;}
    
    // function type
    public Boolean match(ArrayList<TigerType> parameters) {return false;}
    
    public TigerType getReturnType() {return null;}
	
    // alias
    public TigerType getAliasedType() {return null;}
    
    
    // composite
	public TigerType getMemberType(/*Context c, */String fieldName) throws TigerTypeException 
    {
		/*
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
        */
		return null;
    }

    public TigerType getElementType(/*Context c*/) throws TigerTypeException {
    	/*
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
        */
    	return null;
    }
    /*
    // record
    private ArrayList<TigerType> fields;
    // array 
    private TigerType baseType;
    // alias
    private String aliasName;

    private String name;

    private Context aliasContext;
    */
}