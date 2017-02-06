package tiger.context;
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

    private Integer indent;
}