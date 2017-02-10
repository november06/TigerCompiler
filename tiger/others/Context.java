package tiger.others;
//import tiger.TigerValue;
//simport tiger.TigerType;

public class Context 
{
    public Context()
    {
        this.indent = 0;
    }

    public Integer getIndent() {
        return indent;
    }

    public void pushLevel() {
        indent++;
    }

    public void popLevel() {
        indent--;
    }

    public TigerType findVariableType(String variableName)
    {
        // TODO 
        return null;
    }

    public TigerType findType(String alias)
    {
        // TODO 
        return null;
    }

    private Integer indent;
}