package tiger.others;
//import tiger.TigerValue;
//simport tiger.TigerType;
import java.util.ArrayList;


public class Context 
{
    public Context()
    {
        this.indent = 0;
        this.loop = 0;
        scopes = new ArrayList<ScopeContext>();
    }

    public Integer getIndent() {
        return indent;
    }

    public void pushIndentLevel() {
        indent++;
    }

    public void popIndentLevel() {
        indent--;
    }

    
    public Integer getLoop() {
        return loop;
    }

    public void pushLoop() {
        loop++;
    }

    public void popLoopLevel() {
        loop--;
    }
    
    public void startLet() {
    	scopes.add(new ScopeContext());
    }
    
    public void endLet() {
    	scopes.remove(scopes.size() - 1);
    }
    
    
    // TODO add type, remove type
    public void addVariableInCurrentVariableScope()
    {
    	// TODO 
    	//     let
    	//     function
    	//     for index variable (readonly)
    }
    
    public void onVariableDeclaration()
    {
    	// TODO let end
    	//      function end
    	//      for index variable
    }
    
    public void onFunctionDeclaration()
    {
    	// TODO when function declaration encountered
    	// recursive functions may be defined here, no two functions could have the same name
    	
    	// all functions in this sequence will begin the scope here (IMPORTANT this is not the same as variables)
    }
    
    public void onTypeDeclaration()
    {
    	
    }

    public TigerType findIdentifierType(String variableName)
    {
        // TODO 
        return null;
    }

    public TigerType findType(String typeName)
    {
        // TODO 
        return null;
    }
    
    public void addType(String name, TigerType t)
    {
    	
    }
    
    public void addFunction(String name, TigerType t)
    {
    	
    }
    
    public void addVariable(String name, TigerType t)
    {
    	// TODO
    }

    
    // bool is in function sequences
    //      is in type sequences
    // record/array variable table (global scope ?   redefined?)
    // type table name -> tigertype
    // function name/variable name table
    private Integer indent;
    private Integer loop;
    private ArrayList<ScopeContext> scopes;
}