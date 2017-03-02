package tiger.others;

import java.util.ArrayList;

public class TigerRecordType extends TigerType {
	public final static TigerType TigerNilType = new TigerRecordType();
	// TODO value is nil, is it ok should still have type
	private TigerRecordType()
	{
		// TODO: nil type, could be assigned to any other record type
	}
	
	public TigerRecordType(String recordName)
	{
		// TODO Shane
	}
	
	public TigerRecordType(ArrayList<TigerType> fields)
	{
		subTypes = fields;
	}
	
	@Override
	public TigerType getMemberType(String fieldName) throws TigerTypeException {
		// TODO Auto-generated method stub
		return super.getMemberType(fieldName);
	}

	public ArrayList<TigerType> getSubTypes() {
		return subTypes;
	}


	public void setSubTypes(ArrayList<TigerType> subTypes) {
		this.subTypes = subTypes;
	}

	private ArrayList<TigerType> subTypes;
}
