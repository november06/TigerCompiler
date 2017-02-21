package tiger.others;

import java.util.ArrayList;

public class TigerSimpleType extends TigerType {
	private final static Integer nil = 0, integer = 1, string = 2;
	public final static TigerType TigerIntegerType = new TigerSimpleType(integer);
	public final static TigerType TigerStringType = new TigerSimpleType(string);
	public final static TigerType tigerNilType = new TigerSimpleType(nil);
	
	private TigerSimpleType(Integer subType)
	{
		super();
		this.subType = subType;
	}
	
	@Override
    public Boolean isInteger()
    {
    	return this.subType == integer;
    }

    @Override
    public Boolean isString() {
    	return this.subType == string;
    }

    @Override
    public Boolean isNil() {
    	return this.subType == nil;
    }

	private Integer subType;
}
