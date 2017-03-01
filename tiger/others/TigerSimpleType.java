package tiger.others;

import java.util.ArrayList;

public class TigerSimpleType extends TigerType {
	private final static Integer integer = 0, string = 1;
	public final static TigerType TigerIntegerType = new TigerSimpleType(integer);
	public final static TigerType TigerStringType = new TigerSimpleType(string);
	
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

	private Integer subType;
}
