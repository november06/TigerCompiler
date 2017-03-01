package tiger;


public class TigerValue {
    public static final Integer STRING = 0, INTEGER = 1, NIL = 2;

    public TigerValue(String value) 
    {
        SetString(value);
    }

    public TigerValue()
    {
        // SetNil();
    }

    public TigerValue(Integer value)
    {
        SetInteger(value);
    }

    public boolean IsInteger() { return isInteger; } 

    public void SetInteger(Integer value) {
        isInteger = true;
        isString = false;

        integerValue = value;
    }

    public boolean IsString() { return isString; }

    public void SetString(String value) {
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

    private boolean isString;
    private boolean isInteger;

    private String stringValue;
    private Integer integerValue;
}