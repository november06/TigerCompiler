package tiger.others;

import java.util.ArrayList;

public class TigerFunctionType extends TigerType {
	public TigerFunctionType(String name, ArrayList<TigerType> parameterTypes, TigerType returnType)
	{
		
	}
	
	@Override
	public Boolean match(ArrayList<TigerType> parameters) {
		// TODO Auto-generated method stub
		return super.match(parameters);
	}

	@Override
	public TigerType getReturnType() {
		// TODO Auto-generated method stub
		return super.getReturnType();
	}
}
