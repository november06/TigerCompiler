package tiger;


public class TigerValue {
    public TigerValue(String value) 
    {
        SetString(value);
    }

    public TigerValue()
    {
        SetNil();
    }

    public TigerValue(Integer value)
    {
        SetInteger(value);
    }

    public boolean IsNil() { return isNil; }

    public void SetNil() {
        isNil = true;
        isInteger = false;
        isString = false;
    }

    public boolean IsInteger() { return isInteger; } 

    public void SetInteger(Integer value) {
        isNil = false;
        isInteger = true;
        isString = false;

        integerValue = value;
    }

    public boolean IsString() { return isString; }

    public void SetString(String value) {
        isNil = false;
        isInteger = false;
        isString = true;
        stringValue = value;
    }

    public String GetStringValue() {
        if (IsString()) {
            return stringValue;
        }
        else {
            throw new RuntimeException("This is not a string value.");
        }
    }

    public int GetIntValue() {
        if (IsInteger()) {
            return integerValue;
        }
        else {
            throw new RuntimeException("This is not an integer value.");
        }
    }

    private boolean isNil;
    private boolean isString;
    private boolean isInteger;

    private String stringValue;
    private Integer integerValue;
}