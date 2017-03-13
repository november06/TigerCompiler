package tiger.others;

public class RecordField {
	public RecordField(String name, TigerType type)
	{
		this.setFieldName(name); 
		this.setFieldType(type);
	}

	public TigerType getFieldType() {
		return fieldType;
	}
	public void setFieldType(TigerType fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	private TigerType fieldType;
	private String fieldName;
}
