package tiger.others;

import java.util.ArrayList;

public class TigerAliasType extends TigerType {

	@Override
	public Boolean isInteger() {
		return findAliasedType().isInteger();
	}

	@Override
	public Boolean isString() {
		return findAliasedType().isString();
	}

	@Override
	public Boolean match(ArrayList<TigerType> parameters) {
		return findAliasedType().match(parameters);
	}

	@Override
	public TigerType getReturnType() {
		return findAliasedType().getReturnType();
	}

	@Override
	public TigerType getAliasedType() {
		return findAliasedType().getAliasedType();
	}

	@Override
	public TigerType getMemberType(String fieldName) throws TigerTypeException {
		return findAliasedType().getMemberType(fieldName);
	}

	@Override
	public TigerType getElementType() throws TigerTypeException {
		return findAliasedType().getElementType();
	}
	
	private TigerType findAliasedType() {
	    return context.findType(aliasName);
	}
	
	private Context context;
	private String aliasName;
}
