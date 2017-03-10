package tiger.others;

import java.util.ArrayList;

public class TigerRecordType extends TigerType {
	public final static TigerType TigerNilType = new TigerRecordType();
	// TODO value is nil, is it ok should still have type
	private TigerRecordType()
	{
		// TODO: nil type, could be assigned to any other record type
	}
	
	//public TigerRecordType(String recordName)
	//{
		// TODO Shane
	//}
	
	public TigerRecordType(ArrayList<RecordField> recordFields)
	{
		this.recordFields = recordFields;
	}
	
	@Override
	public TigerType getMemberType(String fieldName) throws TigerTypeException {
		// TODO Auto-generated method stub
		return super.getMemberType(fieldName);
	}

	public ArrayList<RecordField> getRecordFieldList() {
		// TODO
		return null;
	}


	private ArrayList<RecordField> recordFields;
}
